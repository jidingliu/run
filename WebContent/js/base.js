
function checkCode1(){
	$.get('checkCode', {
		authCode:$("#code1").val()
	}, function(data) {
		alert(data.msg)
	}, 'json');
};
function createText() {
	var temp = document.getElementById("register_re");
	if (isChecked("re")) {
		temp.style.display = "block";
	} else {
		temp.style.display = "none";
		var tempInput = document.getElementById("recommender");
		var tempInput2 = document.getElementById("recommender2");
		tempInput.value = "";
		tempInput2.value = "";
	}
}
function changeRecommander(tempInput) {
	var tempInputValue = tempInput.value;
	var tempInput2 = document.getElementById("recommender");
	tempInput2.value = tempInputValue;
}
function changeText(){
	var temp = document.getElementById("retext");
	if(isChecked("re")){
		temp.style.display="table-cell";
	}else{
		temp.style.display="none";	
	}	   
}
function validateRegisterForm() {

	if (document.form1.nickname.value=="") {
		alert("用户名不能为空");
		return false;
	}
	if (checkStrLength(document.form1.password.value) < 6) {
		alert("密码长度至少要6位");
		return false;
	}
	if (document.form1.password.value=="") {
		alert("密码不能为空");
		return false;
	}
	if (document.form1.passwdre.value=="") {
		alert("确认密码不能为空");
		return false;
	}
	
	if (document.form1.email.value=="") {
		alert("邮箱不能为空");
		return false;
	}
	if (!isEmail(document.form1.email.value)) {
		alert("请输入正确的邮箱格式");
		return false;
	}
	if (document.form1.passwordquestion.value=="") {
		alert("密码提示问题不能为空");
		return false;
	}
	if (document.form1.passwordanswer.value=="") {
		alert("密码提示答案不能为空");
		return false;
	}
	if (checkStrLength(document.form1.passwordanswer.value) < 6) {
		alert("密码提示答案至少要6位");
		return false;
	}
	if (document.form1.gender.value=="") {
		alert("性别不能为空");
		return false;
	}
	if (document.form1.age.value=="") {
		alert("年龄不能为空");
		return false;
	}
	if (document.form1.authCode.value=="") {
		alert("验证码不能为空");
		return false;
	}
	
}
function validateModifyForm() {
	if (document.mform.oldpasswd.value=="") {
		alert("旧密码不能为空");
		return false;
	}
	if (checkStrLength(document.mform.oldpasswd.value) < 6) {
		alert("密码长度至少要6位");
		return false;
	}
	if (document.mform.newpasswd.value=="") {
		alert("新密码不能为空");
		return false;
	}
	if (document.mform.password.value=="") {
		alert("确认密码不能为空");
		return false;
	}
	if (document.mform.newpasswd.value != document.form1.password.value) {
		alert("两次输入密码不想同,请重新输入");
		return false;
	}
	if (document.mform.email.value=="") {
		alert("邮箱不能为空");
		return false;
	}
	if (!isEmail(document.mform.email.value)) {
		alert("请输入正确的邮箱格式");
		return false;
	}
	if (document.mform.passwordquestion.value=="") {
		alert("密码提示问题不能为空");
		return false;
	}
	if (document.mform.passwordanswer.value=="") {
		alert("密码提示答案不能为空");
		return false;
	}
	if (checkStrLength(document.mform.passwordanswer.value) < 6) {
		alert("密码提示答案至少要6位");
		return false;
	}
	if (document.mform.gender.value=="") {
		alert("性别不能为空");
		return false;
	}
}
function checkGetPasswdForm() {
	if (document.pform.nickname.value=="") {
		alert("用户名不能为空");
		return false;
	}
	if (document.pform.passwordquestion.value=="") {
		alert("密码提示问题不能为空");
		return false;
	}
	if (document.pform.passwordanswer.value=="") {
		alert("密码提示答案不能为空");
		return false;
	}
	if (/^\s*$/.test(document.pform.nickname.value)) {
		alert("\u5bf9\u4e0d\u8d77\uff0c\u7528\u6237\u540d\u4e0d\u53ef\u4ee5\u4e3a\u7a7a\uff01");
		return false;
	}
	if (/^\s*$/.test(document.pform.passwordquestion.value)) {
		alert("\u5bf9\u4e0d\u8d77\uff0c\u5bc6\u7801\u63d0\u793a\u95ee\u9898\u4e0d\u53ef\u4ee5\u4e3a\u7a7a\uff01");
		return false;
	}
	if (/^\s*$/.test(document.pform.passwordanswer.value)) {
		alert("\u5bf9\u4e0d\u8d77\uff0c\u5bc6\u7801\u63d0\u793a\u7b54\u6848\u4e0d\u53ef\u4ee5\u4e3a\u7a7a\uff01");
		return false;
	}
}
function checkLoginForm() {
	if(document.form2.nickname.value == ""){
		alert("请输入用户名");
		return false;
	}
	if (/^\s*$/.test(document.form2.nickname.value)) {
		alert("\u5bf9\u4e0d\u8d77\uff0c\u7528\u6237\u540d\u4e0d\u53ef\u4ee5\u4e3a\u7a7a\uff01");
		return false;
	}
	if(document.form2.password.value == ""){
		alert("请输入密码");
		return false;
	}
	if (/^\s*$/.test(document.form2.password.value)) {
		alert("\u5bf9\u4e0d\u8d77\uff0c\u5bc6\u7801\u4e0d\u53ef\u4ee5\u4e3a\u7a7a\uff01");
		return false;
	}
	if (document.form2.authCode.value=="") {
		alert("验证码不能为空");
		return false;
	}
}

function checkspace() {
	      
	if (document.sform.opinion.value=="") {
		alert("应该有自己的主张哦");
		return false;
	}
  if (document.sform.runstar.value=="") {
		alert("你喜欢的体育明星呢");
		return false;
	}
  if (document.sform.cellphone.value=="") {
		alert("填写你的手机号码哦");
		return false;
	}
  if (document.sform.runplace.value=="") {
		alert("你经常在哪运动呀");
		return false;
	}
  if(document.sform.icon.value == ""){
	  alert("请上传个性化形象");
	  return false;
  }
}

function sendInfo() {
	if(document.sendInfoForm.receiver.value == ""){
		alert("收件人不能为空");
		return false;
	}
	if(document.sendInfoForm.title.value == ""){
		alert("主题不能为空");
		return false;
	}
	if(document.sendInfoForm.content.value == ""){
		alert("内容不能为空");
		return false;
	}
}

