<template>
  <section>
    <el-col :span="24" class="toolbar">
      <el-button type="primary" @click="create">创建新项目</el-button>
    </el-col>
  <el-table
    :data="tableData"
    style="width: 100%">
    <el-table-column
      prop="name"
      label="编号"
      width="280">
    </el-table-column>
    <el-table-column
      prop="name2"
      label="项目名称"
      width="280">
    </el-table-column>
    <el-table-column
      prop="name3"
      label="状态"
      width="280">
    </el-table-column>
    <el-table-column
      label="操作">
      <template scope="scope">
        <el-button size="small" @click="edit(scope.$index)">修改</el-button>
        <el-button size="small" @click="del(scope.$index)">删除</el-button>
        <el-button size="small" @click="review(scope.$index)">评审</el-button>
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
        // 表格初始数据
        tableData: [{name: '1', name2: '2', name3: '3'}]
      }
    },
    methods: {
      handleCurrentChange (val) {
        alert('加载第' + val + '页数据')
        // this.page = val
      },
      create () {
        this.$router.push({name: '创建项目'})
      },
      edit (index) {
        alert('下标为' + index)
        this.$router.push({name: '编辑项目', query: {'id': index}})
      },
      del (index) {
        alert('删除下标为' + index)
      },
      review (index) {
        alert('评审下标为' + index)
      }
    }
  }
</script>
