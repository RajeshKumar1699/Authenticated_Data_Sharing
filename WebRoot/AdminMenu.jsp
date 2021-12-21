<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
div.scrollmenu {
    background-color: green;
    overflow: auto;
    white-space: nowrap;
}

div.scrollmenu a {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px;
    text-decoration: none;
}

div.scrollmenu a:hover {
    background-color: #777;
}
</style>
</head>
<body>

<div class="scrollmenu">
  <a href="AdminHome.jsp">AdminHome</a><!--
  <a href="#news">News</a>
  -->
  <a href="NewUserRequestServlet">NewRequest</a>
  <a href="UserDetails.jsp">ViewUsersandOwners</a>
  <a href="ChangePassword.jsp">ChangePassword</a>
  <a href="LogoutAction.jsp">Logout</a>
  <!--
  <a href="#tools">Tools</a>  
  <a href="#base">Base</a>
  <a href="#custom">Custom</a>
  <a href="#more">More</a>
  <a href="#logo">Logo</a>
  <a href="#friends">Friends</a>
  <a href="#partners">Partners</a>
  <a href="#people">People</a>
  <a href="#work">Work</a>
--></div>


</body>
</html>
