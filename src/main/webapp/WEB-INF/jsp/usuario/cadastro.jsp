<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

<body>
<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

<div class="container">
    <h2>Cadastro de Usuários</h2>

    <table class="table table-borderless">
        <tbody>
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
        <tr>
            <td>
                <form action="/usuario/cep" method="POST">
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="Informe o CEP" required minlength="8"
                               aria-label="CEP" aria-describedby="basic-addon2" value="${usuario.endereco.cep}"
                               maxlength="8"
                               name="cep">
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" type="submit">Pesquisa
                                CEP
                            </button>
                        </div>
                    </div>
                </form>
            </td>
            <td>
                <form action="/usuario/salvar" enctype="multipart/form-data" method="POST">

                    <div class="form-group">
                        <label>Nome:</label>
                        <input type="text" class="form-control" required
                               placeholder="Entre com o nome do usuario" value="${usuario.nome}"
                               name="nome">
                    </div>

                    <div class="form-group">
                        <div class="row ajusteRow">
                            <div class="col-md-8">
                                <c:if test="${oper == 'incluir'}">
                                    <label>E-mail:</label>
                                    <input type="email" class="form-control" placeholder="Informe o e-mail" required
                                           value="${usuario.email}" name="email">
                                </c:if>
                                <c:if test="${oper == 'alterar'}">
                                    <label>E-mail:</label>
                                    <input type="email" class="form-control" placeholder="Informe o e-mail" disabled
                                           value="${usuario.email}" name="email">
                                </c:if>
                            </div>
                            <div class="col-md-4">
                                <label>Telefone:</label>
                                <input type="text" class="form-control" placeholder="(00) 0000-0000"
                                       data-mask="(00) 0000-0000"
                                       data-mask-selectonfocus="true"
                                       required value="${usuario.telefone}"
                                       name="telefone">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row ajusteRow">
                            <div class="col-md-2">
                                <label>CEP:</label>
                                <input type="text" class="form-control" required placeholder="informe o cep"
                                       value="${usuario.endereco.cep}" name="cep">
                            </div>
                            <div class="col-md-8">
                                <label>Cidade:</label>
                                <input type="text" class="form-control" placeholder="Informe a localidade" required
                                       value="${usuario.endereco.localidade}" name="localidade">
                            </div>
                            <div class="col-md-2">
                                <label>UF:</label>
                                <input type="text" class="form-control" placeholder="Informe a UF" required size="5"
                                       value="${usuario.endereco.uf}" name="uf">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row ajusteRow">
                            <div class="col-md-9">
                                <label>Logradouro:</label>
                                <input type="text" class="form-control" placeholder="informe o logradouro" required
                                       value="${usuario.endereco.logradouro}" name="logradouro">
                            </div>
                            <div class="col-md-3">
                                <label>Número:</label>
                                <input type="text" class="form-control" placeholder="informe o número" required
                                       value="${usuario.endereco.numero}" name="numero">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row ajusteRow">
                            <div class="col-md-6">
                                <label>Complemento:</label>
                                <input type="text" class="form-control" placeholder="informe o complemento"
                                       value="${usuario.endereco.complemento}" name="complemento">
                            </div>
                            <div class="col-md-6">
                                <label>Bairro:</label>
                                <input type="text" class="form-control" placeholder="Informe o bairro"
                                       value="${usuario.endereco.bairro}" name="bairro">
                            </div>
                        </div>
                    </div>

                    <div class="input-group mb-3">
                        <label for="arquivo">Imagem:</label>
                        <input type="file" id="arquivo" name="arquivo" class="form-control">
                    </div>
                    <br/>
                    <c:if test="${oper == 'incluir'}">
                        <button type="submit" class="btn btn-default">Cadastrar</button>
                    </c:if>
                    <c:if test="${oper == 'alterar'}">
                        <button type="submit" class="btn btn-default">Alterar</button>
                    </c:if>
                </form>
            </td>
        </tr>
        </tbody>
    </table>
</div>

</body>

</html>
