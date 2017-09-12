<template>
  <section>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="变更单号" prop="orderNum" >
      <el-input v-model="ruleForm.orderNum" style="width: 200px"></el-input>
    </el-form-item>
    <el-form-item label="项目名称" prop="name">
      <el-select v-model="ruleForm.name" placeholder="请选择项目名称">
        <el-option label="区域一" value="shanghai"></el-option>
        <el-option label="区域二" value="beijing"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="发布状态" prop="status">
      <el-select v-model="ruleForm.status" placeholder="请选择发布状态">
        <el-option label="区域一" value="shanghai"></el-option>
        <el-option label="区域二" value="beijing"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="时间范围" required>
      <el-col :span="11">
        <el-form-item >
          <el-date-picker
            v-model="ruleForm.date"
            type="datetimerange"
            :picker-options="ruleForm.pickerOptions2"
            placeholder="选择时间范围"
            align="right">
          </el-date-picker>
        </el-form-item>
      </el-col>
    </el-form-item>
    <el-form-item label="执行时间" prop="time">
      <el-select v-model="ruleForm.time" placeholder="请选择执行时间">
        <el-option label="区域一" value="shanghai"></el-option>
        <el-option label="区域二" value="beijing"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="项目负责人" prop="person" >
      <el-input v-model="ruleForm.person" style="width: 200px"></el-input>
    </el-form-item>
    <el-form-item label="健康状态" prop="healthy">
      <el-select v-model="ruleForm.healthy" placeholder="请选择健康状态">
        <el-option label="区域一" value="shanghai"></el-option>
        <el-option label="区域二" value="beijing"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">查询</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
      <el-button >导出</el-button>
    </el-form-item>
  </el-form>
  <el-table
    :data="ruleForm.tableData"
    style="width: 100%">
    <el-table-column
      prop="name"
      label="变更单号"
      width="100">
    </el-table-column>
    <el-table-column
      prop="name2"
      label="项目名称"
      width="100">
    </el-table-column>
    <el-table-column
      prop="name3"
      label="在当前发布状态"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name4"
      label="健康状态"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name5"
      label="发布次数"
      width="180">
    </el-table-column>
    <el-table-column
      prop="date"
      label="最后发布时间"
      width="180">
    </el-table-column>
    <el-table-column
      label="操作">
      <template scope="scope">
        <el-button
          size="small"
          @click="info(scope.$index)">详情</el-button>
        <el-button
          size="small"
          @click="statistics(scope.$index)">统计</el-button>
      </template>
    </el-table-column>
  </el-table>
    <el-col :span="24" class="toolbar">
      <el-pagination layout="prev, pager, next" @current-change="handleCurrentChange" :page-size="2" :total="100"
                     style="float:right;">
      </el-pagination>
    </el-col>
  </section>
</template>
<script>
  export default {
    data () {
      return {
        ruleForm: {
          orderNum: '',
          name: '',
          status: '',
          // 时间范围快捷选项
          pickerOptions2: {
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
            }]
          },
          date: '',
          time: '',
          delivery: false,
          person: '',
          healthy: '',
          // 表格初始数据
          tableData: [{name: '1', name2: '2', name3: '3', name4: '4', name5: '5', date: '2017'}]
        },
        rules: {
          orderNum: [
            { required: true, message: '请输入变更单号', trigger: 'blur' },
            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '请选择项目名称', trigger: 'change' }
          ],
          status: [
            { required: true, message: '请选择发布状态', trigger: 'change' }
          ],
          time: [
            { required: true, message: '请选择执行时间', trigger: 'change' }
          ],
          person: [
            { required: true, message: '请输入变更单号', trigger: 'blur' },
            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          healthy: [
            { required: true, message: '请选择健康状态', trigger: 'change' }
          ]
        }
      }
    },
    methods: {
      handleCurrentChange (val) {
        alert('加载第' + val + '页数据')
        // this.page = val
      },
      info (index) {
        alert('详细下标为' + index)
      },
      statistics (index) {
        alert('评审下标为' + index)
      },
      submitForm (formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!')
          } else {
            console.log('error submit!!')
            return false
          }
        })
      },
      resetForm (formName) {
        this.$refs[formName].resetFields()
      }
    }
  }
</script>
