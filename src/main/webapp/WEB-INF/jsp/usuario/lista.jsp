<%@page import="br.edu.infnet.marianabs.appDoacao.model.domain.User" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>


<body>

<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

<div class="container">
    <h3>Usuário</h3>

    <form action="/usuario" method="GET">
        <button type="submit" class="btn btn-link">Incluir</button>
    </form>

    <hr>

    <c:if test="${not empty msg}">
        <c:if test="${not empty idMsg}">
            <c:if test="${idMsg == 'sucesso'}">
                <div class="alert alert-success">
                    <strong>Sucesso!</strong> ${msg}
                </div>
            </c:if>
            <c:if test="${idMsg == 'erro'}">
                <div class="alert alert-danger">
                    <strong>ERRO!</strong> ${msg}
                </div>
            </c:if>
        </c:if>
        <c:if test="${empty idMsg}">
            <div class="alert alert-success">
                <strong>Sucesso!</strong> ${msg}
            </div>
        </c:if>
    </c:if>
    <c:if test="${not empty lista}">

        <h4>Quantidade de Usuários cadastrados: ${lista.size()}!!!</h4>

        <hr>

        <table class="table table-striped">
            <thead>
            <tr>
                <th style="text-align: center;">Id</th>
                <th style="text-align: center;">Nome</th>
                <th style="text-align: center;">E-mail</th>
                <th style="text-align: center;">Telefone</th>
                <th style="text-align: center;">Ação</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="a" items="${lista}">
                <tr>
                    <td style="text-align: center;">${a.id}</td>
                    <td style="text-align: center;">${a.nome}</td>
                    <td style="text-align: center;">${a.email}</td>
                    <td style="text-align: center;">${a.telefone}</td>
                    <td style="text-align: center;"><a href="/usuario/${a.id}/montaAlteracao">Alterar</a></td>
                    <td style="text-align: center;"><a href="/usuario/${a.id}/excluir">Excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty lista}">
        <h4>Não há Clientes cadastrados!!!</h4>
    </c:if>
</div>
</body>

</html>