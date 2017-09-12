<template>
  <section>
<!--
    <el-row class="margin-bottom-20" style="margin-top: 20px;">
      <el-button type="primary" icon="plus" @click="" size="big">陆家嘴DC</el-button>
      <el-button type="primary" icon="plus" @click="" size="big">外高桥DC</el-button>
      <el-button type="primary" icon="plus" @click="" size="big">异地DC</el-button>
    </el-row>
-->
    <br/>
    <!-- 下拉插件-->
    <el-dropdown @command="handleCommand" trigger="click">
      <span class="el-dropdown-link">
        下拉菜单<i class="el-icon-caret-bottom el-icon--right"></i>
      </span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item command="ogon">黄金糕</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>

    <!-- 日期插件 -->
    <el-date-picker style="float: right" @change="changeDate"
      v-model="date"
      type="date"
      placeholder="选择日期">
    </el-date-picker>
    <br/>
    <el-row class="margin-bottom-20" style="margin-top: 20px;">
      <span>正在发布： {{graphInfo.platformResource.clusterNum}}</span><span class="platNum">项目总数： {{graphInfo.platformResource.hostNum}}</span>
      <span class="platNum">发布总数： {{graphInfo.platformResource.appGroupNum}}</span>
      <span class="platNum">发布失败： {{graphInfo.platformResource.appNum}}</span>
    </el-row>

    <el-tabs v-model="activeName">
        <el-row :gutter="20">
          <el-col :span="14">
            <h1>项目运营趋势</h1>
            <span>1.6</span><span>job平均次数</span><br/><br/>
            <el-button size="small">默认按钮</el-button>
            <el-button size="small">默认按钮</el-button>
            <el-button size="small">默认按钮</el-button>
            <!-- 日期范围插件 -->
            <div class="block"style="float: right">
              <el-date-picker
                v-model="histogramDate1"
                type="daterange"
                align="right"
                placeholder="选择日期范围"
                :picker-options="histogramDateRange1"
                @change="changeHistogramDate1" size="small">
              </el-date-picker>
            </div>
            <div id="hostRec" class="monitorDiv"></div>
          </el-col>
          <el-col :span="9">
            <h1>项目排行榜</h1>
            <el-button size="small" >默认按钮</el-button>
            <el-button size="small" >默认按钮</el-button>
            <el-button size="small" >默认按钮</el-button><a style="float: right">更多</a>
            <br/><br/>
            <el-table
              :data="tableData"
              style="width: 100%">
              <el-table-column
                prop="date"
                label="排名"
                width="45">
              </el-table-column>
              <el-table-column
                prop="name"
                label="项目"
                width="110">
              </el-table-column>
              <el-table-column
                prop="add"
                label="占比"
                width="120">
                <template scope="scope">
                  <el-progress :percentage="70"></el-progress>
                </template>
              </el-table-column>
              <el-table-column
                prop="address"
                label="周环比"
                >
              </el-table-column>
            </el-table>
          </el-col>
        </el-row>
      <el-row>
          <el-col :span="8" center="center">
            <h1>项目运行情况（200个）</h1>
            <div id="doughnutChart" class="monitorDiv" ></div>
          </el-col>
          <el-col :span="7">
            <h1>项目发布情况</h1>
            <div id="cpuUsage" class="monitorDiv"></div>
          </el-col>
          <el-col :span="7">
            <h1>分部质量分</h1>
            <div id="histogram" class="monitorDiv"></div>
          </el-col>
        </el-row>
    </el-tabs>


  </section>
</template>

<script>
  import {mapState, mapActions} from 'vuex'
  import * as type from '../../store/graph/mutations_types'

  const echarts = require('echarts/lib/echarts')
  require('echarts/lib/chart/pie')
  require('echarts/lib/chart/bar')
  // 引入提示框和标题组件
  require('echarts/lib/component/tooltip')
  require('echarts/lib/component/toolbox')
  require('echarts/lib/component/title')
  require('echarts/lib/component/legend')

  export default {
    data () {
      return {
        cpuChart: null,
        hostChart: null,
        doughnutChart: null, // 环状图
        activeName: 'first',
        date: '', // 日期
        histogramDate1: '', // 第一个柱状图日期范围开始值
        // 第一个柱状图日期范围快捷值
        histogramDateRange1: {
          shortcuts: [{
            text: '最近一周',
            onClick (picker) {
              const end = new Date()
              const start = new Date()
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
              picker.$emit('pick', [start, end])
            }
          }, {
            text: '最近一个月',
            onClick (picker) {
              const end = new Date()
              const start = new Date()
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
              picker.$emit('pick', [start, end])
            }
          }, {
            text: '最近三个月',
            onClick (picker) {
              const end = new Date()
              const start = new Date()
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
              picker.$emit('pick', [start, end])
            }
          }],
          histogramChart: null
        },
        // 表格数据
        tableData: [{
          date: '1',
          name: '王小虎虎A',
          address: '100%'
        }, {
          date: '2',
          name: '王小虎',
          address: '100%'
        }, {
          date: '3',
          name: '王小虎',
          address: '100%'
        }, {
          date: '4',
          name: '王小虎',
          address: '100%'
        }, {
          date: '5',
          name: '王小虎',
          address: '100%'
        }, {
          date: '6',
          name: '王小虎',
          address: '100%'
        }]
      }
    },
    watch: {
      graphInfo () {
        this.showPlat()
      }
    },
    computed: {
      ...mapState({
        graphInfo (state) {
          return state.graph.graphInfo
        }
      })
    },
    methods: {
      ...mapActions({
        fetchGraph: type.FETCH_GRAPH
      }),
      handleCommand (command) {
        this.$message('click on item ' + command)
      },
      changeDate () {
        alert(this.date)
      },
      changeHistogramDate1 () {
        alert(this.histogramDateRange1)
      },
      showPlat () {
        let cpuUsage = document.getElementById('cpuUsage')
        this.cpuChart = echarts.init(cpuUsage, null, {width: 350, height: 200})
        let option = {
          title: {text: '', x: 'center'},
          tooltip: {},
          legend: {
            orient: 'vertical',
            x: 'left',
            data: ['已使用量', '未使用量']
          },
          series: [{
            name: 'cpu使用',
            type: 'pie',
            data: [
              {value: 25, name: '已使用量'},
              {value: 75, name: '未使用量'}
            ]
          }]
        }
        if (this.graphInfo && this.graphInfo.platformResource) {
          option.series[0].data = [
            {value: this.graphInfo.platformResource.cpuUtilizationRate, name: '已使用量'},
            {value: (1 - this.graphInfo.platformResource.cpuUtilizationRate).toFixed(2), name: '未使用量'}
          ]
        }
        this.cpuChart.setOption(option)
      },
      showHost () {
        let hostRec = document.getElementById('hostRec')
        this.hostChart = echarts.init(hostRec, null, {width: 700, height: 300})
        let hostOption = {
          title: {text: ''},
          tooltip: {},
          legend: {
            data: ['CPU', '内存']
          },
          xAxis: [
            {
              type: 'category',
              data: ['192.168.11.11', '192.168.11.12', '192.168.11.13', '192.168.11.14']
            }
          ],
          yAxis: [
            {
              type: 'value'
            }
          ],
          series: [{
            name: 'CPU',
            type: 'bar',
            data: [2.0, 4.9, 7.0, 23.2]
          }, {
            name: '内存',
            type: 'bar',
            data: [2.6, 7.0, 9.5, 28.2]
          }]
        }
        if (this.graphInfo && this.graphInfo.hostResources && Array.isArray(this.graphInfo.hostResources) && this.graphInfo.hostResources.length > 0) {
          let host = this.graphInfo.hostResources
          let hostIp = hostOption.xAxis[0].data = []
          let cpuData = hostOption.series[0].data = []
          let memData = hostOption.series[1].data = []
          for (let h of host) {
            hostIp.push(h.ip)
            cpuData.push(h.cpuUtilizationRate)
            memData.push(h.memUtilizationRate)
          }
        }
        this.hostChart.setOption(hostOption)
      },
      showDoughnutChart () {
        let doughnutChart = document.getElementById('doughnutChart')
        this.doughnutChart = echarts.init(doughnutChart, null, {width: 350, height: 200})
        let doughnutChartOption = {
          tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
          },
          legend: {
            orient: 'vertical',
            x: 'left',
            data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
          },
          toolbox: {
            show: true,
            feature: {
              mark: {show: true},
              dataView: {show: true, readOnly: false},
              magicType: {
                show: true,
                type: ['pie', 'funnel'],
                option: {
                  funnel: {
                    x: '25%',
                    width: '50%',
                    funnelAlign: 'center',
                    max: 1548
                  }
                }
              },
              restore: {show: true},
              saveAsImage: {show: true}
            }
          },
          calculable: true,
          series: [
            {
              name: '访问来源',
              type: 'pie',
              radius: ['50%', '70%'],
              itemStyle: {
                normal: {
                  label: {
                    show: false
                  },
                  labelLine: {
                    show: false
                  }
                },
                emphasis: {
                  label: {
                    show: true,
                    position: 'center',
                    textStyle: {
                      fontSize: '15',
                      fontWeight: 'bold'
                    }
                  }
                }
              },
              data: [
                {value: 335, name: '直接访问'},
                {value: 310, name: '邮件营销'},
                {value: 234, name: '联盟广告'},
                {value: 135, name: '视频广告'},
                {value: 1548, name: '搜索引擎'}
              ]
            }
          ]
        }
        this.doughnutChart.setOption(doughnutChartOption)
      },
      showHistogramChart () {
        let histogram = document.getElementById('histogram')
        this.histogramChart = echarts.init(histogram, null, {width: 300, height: 300})
        let histogramOption = {
          color: ['#3398DB'],
          tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
              type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
          },
          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
          },
          xAxis: [
            {
              type: 'category',
              data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
              axisTick: {
                alignWithLabel: true
              }
            }
          ],
          yAxis: [
            {
              type: 'value'
            }
          ],
          series: [
            {
              name: '直接访问',
              type: 'bar',
              barWidth: '60%',
              data: [10, 52, 200, 334, 390, 330, 220]
            }
          ]
        }
        this.histogramChart.setOption(histogramOption)
      }
    },
    mounted () {
      this.fetchGraph()
      this.showPlat()
      this.showHost()
      this.showDoughnutChart()
      this.showHistogramChart()
    }
  }
</script>

<style scoped>
  .monitorDiv {
    width: 700px;
    height: 500px;
  }
  .platNum {
    margin-left: 10px;
  }
</style>
