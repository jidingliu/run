<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="杰普软件(www.briup.com)" />
<meta name="description" content="杰普软件(www.briup.com)" />
<title>杰普——跑步社区</title>
<link rel="stylesheet" type="text/css" id="css" href="style/main.css" />
<link rel="stylesheet" type="text/css" id="css" href="style/style1.css" />
<script src="js/main.js" type="text/javascript"></script>
<script src="js/base.js" type="text/javascript"></script>
<!-- 如果msg不为空，代表当前有错误信息，弹出框给用户提示 -->
<c:if test="${msg != null}">
	<script type="text/javascript">
		alert('${msg}');
		</script>
</c:if>
</head>
<body>
<div id="btm">
<div id="main">

  <div id="header">
    <div id="top"></div>
    <div id="logo"><h1>跑步社区</h1></div>
    <div id="mainnav"><ul>
      <li class="login"><a href="login">首页</a></li>
     <li><a href="#">音乐跑不停</a></li>
      <li><a href="#">跑步装备库</a></li>
      <li><a href="#">专业跑步指南</a></li>
      <li><a href="#">跑步论坛</a></li>
	  
      </ul><span></span> </div>
   </div>
  
  <div id="content" align="center">
     
     <div id="center">
      
       <div id="ltd">
         <h2>输入下面信息，系统会帮你找回密码！</h2>
	     <TABLE style="MARGIN: 5px 0px" cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY align="left">
        <TR>
          <TD style="PADDING-TOP: 0px" vAlign=top align=middle width=24 
          rowSpan=3><IMG src="images/icon03.gif" width="16" height=16></TD>
          <TD class=fontgreen style="PADDING-TOP: 2px" width=556><B>系统提醒</B> 
          </TD></TR>
        <TR>
          <TD class=fontgray style="PADDING-TOP: 2px" colSpan=2>
            <OL>
              <LI><FONT color=#ff0000>请确保您输入的用户名存在</FONT></LI>
               <LI><FONT color=#ff0000>请确保您输入的问题以及答案正确</FONT> </LI> 
               <LI><FONT color=#ff0000>请记住系统给您的密码，并及时修改您的密码</FONT> </LI> 
        </OL></TD></TR></TBODY></TABLE>
      <FORM onSubmit="return checkGetPasswdForm();" name="pform" action=passwd_missing.action 
      method=post>
      <TABLE width="100%" align=center border=0>
        <!--DWLayoutTable-->
        <TBODY>
        <TR>
          <TD align=right width="40%">用户名：</TD>
          <TD align=left width="60%"><INPUT class=input1 name=nickname /> </TD></TR>
        <TR>
          <TD align=right width="40%">密码提示问题：</TD>
          <TD align=left width="60%"><INPUT class=input1 name=passwordquestion />          </TD></TR>
        <TR>
          <TD align=right width="40%">密码提示答案：</TD>
          <TD align=left width="60%"><INPUT class=input1 name=passwordanswer />        </TD></TR>
        <TR>
          <TD colSpan=2>
            <DIV align=center><INPUT style="CURSOR: hand" type=submit value=提交 /> 
            &nbsp;&nbsp; <INPUT style="CURSOR: hand" type=reset value=重置 /> 
          </DIV></TD></TR>
        <tr>
          <td height="13"></td>
          <td></td>
        </tr>
        </TBODY></TABLE>
      </FORM>
       </div>
     </div>
     
     <div class="clear"></div>
     
  </div>
  
  <div id="footer">
    <div id="copyright">
       <div id="copy">
       <p>CopyRight&copy;2009</p>
       <p>跑步社区(www.irun.com)</p>
        </div>
    </div>
    <div id="bgbottom"></div>
  </div>
  
</div>
</div>
</body>
</html>
