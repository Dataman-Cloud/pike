<template>
  <section>
    <!--<h1>思い出の欠片たちを拾い集めて</h1>-->
    <!--<h1>幻でもいい、君の姿照らし出せたなら…</h1>-->
    <h1>项目信息</h1>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="项目名称" prop="name">
        <el-input v-model="ruleForm.name" style="width: 300px"></el-input>
      </el-form-item>
      <el-form-item label="健康检查">
        <el-input v-model="ruleForm.healthy" style="width: 300px"></el-input>
      </el-form-item>
      <el-form-item label="所属平台">
        <el-select v-model="ruleForm.platform" placeholder="请选择所属平台">
          <el-option label="区域一" value="shanghai"></el-option>
          <el-option label="区域二" value="beijing"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="项目说明">
        <el-input type="textarea" v-model="ruleForm.explain"  style="width: 600px"></el-input>
      </el-form-item>
      <h1>项目负责人信息</h1>
      <el-form-item label="负责人姓名" prop="name">
        <el-input v-model="ruleForm.person" style="width: 300px"></el-input>
      </el-form-item>
      <el-form-item label="邮件" prop="name">
        <el-input v-model="ruleForm.email" style="width: 300px"></el-input>
      </el-form-item>
      <el-form-item label="电话" prop="name">
        <el-input v-model="ruleForm.phone" style="width: 300px"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">取消</el-button>
      </el-form-item>
    </el-form>
  </section>
</template>
<script>
  export default {
    data () {
      return {
        ruleForm: {
          name: '',
          healthy: '',
          platform: '',
          explain: '',
          person: '',
          phone: '',
          email: ''
        },
        rules: {
          name: [
            {required: true, message: '请输入活动名称', trigger: 'blur'},
            {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
          ],
          person: [
            {required: true, message: '请输入活动名称', trigger: 'blur'},
            {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
          ],
          phone: [
            {required: true, message: '请输入活动名称', trigger: 'blur'},
            {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
          ],
          email: [
            {required: true, message: '请输入活动名称', trigger: 'blur'},
            {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
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
