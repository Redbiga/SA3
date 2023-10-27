<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="experiment.CS2.entity.Contacts" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人通讯录系统</title>
    <script src="js/jquery.js"></script>
</head>

<body>
<button id="to_select">查询联系人</button>
<button id="to_add">添加联系人</button>
<button id="to_delete">删除联系人</button>
<button id="to_update">修改联系人</button>

<div class="new_div" style="display: block;" id="select_div">
    <span>查询联系人：</span>
    <input type="text" name="select_name" id="select_name" placeholder="(若输入为空则会查询所有联系人)"/>
    <button id="select">查询</button>
    <button id="close_select">关闭</button><br>
    <table cellpadding="0" cellspacing="0" style="width: 100%">
        <tr>
            <th width="25%">编号</th>
            <th width="25%">姓名</th>
            <th width="25%">地址</th>
            <th width="25%">电话</th>
        </tr>
        <c:forEach items="${selectRes}" var="contact">
            <tr>
                <td>${contact.ccode}</td>
                <td>${contact.cname}</td>
                <td>${contact.caddress}</td>
                <td>${contact.cphone}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<div class="new_div" id="add_div">
    <span>姓名：</span>
    <input type="text" name="add_name" id="add_name"/><br>
    <span>地址：</span>
    <input type="text" name="add_address" id="add_address"/><br>
    <span>电话：</span>
    <input type="text" name="add_phone" id="add_phone"/><br>
    <button id="add">添加</button>
    <button id="close_add">关闭</button>
</div>

<div class="new_div" id="delete_div">
    <span>删除联系人的编号：</span>
    <input type="text" name="delete_code" id="delete_code"/>
    <button id="delete">删除</button>
    <button id="close_delete">关闭</button>
</div>

<div class="new_div" id="update_div">
    <span>编号：</span>
    <input type="text" name="update_code" id="update_code"/><br>
    <span>姓名：</span>
    <input type="text" name="update_name" id="update_name"/><br>
    <span>地址：</span>
    <input type="text" name="update_address" id="update_address"/><br>
    <span>电话：</span>
    <input type="text" name="update_phone" id="update_phone"/><br>
    <button id="update">修改</button>
    <button id="close_update">关闭</button>
</div>
</body>

<script>
    $("#select").click(function () {
        $.ajax({
            type:"post",
            url:"<%=request.getContextPath()%>/select",
            data:"cname="+$("#select_name").val(),
            dataType:"json",
            success: function (data) {

            }
        })
        setTimeout(location.reload(),3000)
    })
    $("#add").click(function () {
        $.ajax({
            type:"post",
            url:"<%=request.getContextPath()%>/add",
            data:"cname="+$("#add_name").val()+"&caddress="+$("#add_address").val()+"&cphone="+$("#add_phone").val(),
            dataType:"json",
            success: function (data) {

            }
        })
    })
    $("#delete").click(function () {
        $.ajax({
            type:"post",
            url:"<%=request.getContextPath()%>/delete",
            data:"ccode="+$("#delete_code").val(),
            dataType:"json",
            success: function (data) {

            }
        })
    })
    $("#update").click(function () {
        $.ajax({
            type:"post",
            url:"<%=request.getContextPath()%>/update",
            data:"ccode="+$("#update_code").val()+"&cname="+$("#update_name").val()+"&caddress="+$("#update_address").val()+"&cphone="+$("#update_phone").val(),
            dataType:"json",
            success: function (data) {

            }
        })
    })
    $("#to_select").click(function () {
        $("#select_div").css('display','block');
    })
    $("#close_select").click(function () {
        $("#select_div").css('display','none');
    })
    $("#to_add").click(function () {
        $("#add_div").css('display','block');
    })
    $("#close_add").click(function () {
        $("#add_div").css('display','none');
    })
    $("#to_delete").click(function () {
        $("#delete_div").css('display','block');
    })
    $("#close_delete").click(function () {
        $("#delete_div").css('display','none');
    })
    $("#to_update").click(function () {
        $("#update_div").css('display','block');
    })
    $("#close_update").click(function () {
        $("#update_div").css('display','none');
    })
</script>

<style>
    html,body{
        height:100%;overflow:auto;margin:0;
    }
    button {
        background-color: white;
        border: 2px solid #33CCFF;
        color: #007799;
        padding: 32px 64px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 20px;
        margin: 4px 2px;
        transition-duration: 0.5s;
        cursor: pointer;
        border-radius:3px;
    }
    button:hover {
        background-color: #00BBFF;
        color: white;
    }
    span{
        color: white;
        font-size: 20px;
    }
    input{
        width: 200px;
        height: 35px;
    }
    td{
        text-align: center;
    }
    .new_div{
        width: 100%;
        height: 100%;
        color:white;
        background-color:rgba(29,24,21,0.7);
        display: none;
    }
</style>
</html>

