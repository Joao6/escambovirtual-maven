<%-- 
    Document   : view-conversa
    Created on : 15/10/2016, 20:01:29
    Author     : Joao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="mensagemApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Chat</title>
        <!--Import Google Icon Font-->
        <link href="<c:url value="/resources/css/icon.css"/>" rel="stylesheet">    
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/materialize.min.css"/>"  media="screen,projection"/>
        <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="<c:url value="/resources/css/ghpages-materialize.css"/>" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico"/>" type="image/x-icon">

        <link href="<c:url value="/resources/css/modulo-anunciante/base-style.css"/>" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="<c:url value="/resources/css/modulo-anunciante/mensagem-view-style.css"/>" type="text/css" rel="stylesheet" media="screen,projection"/>
        <!--SCRIPTS-->
        <script src="<c:url value="/resources/js/angular.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/mensagem/app/mensagem-list-app.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/mensagem/controllers/mensagem-list-controller.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/mensagem/services/mensagem-list-service.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/mensagem/values/mensagem-list-value.js"/>"></script>


        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.1.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/materialize.min.js"/>"></script>
        <script src="<c:url value="/resources/js/init.js"/>"></script>
    </head>
    <body ng-controller="MensagemController">
        <header>
            <jsp:include page="/resources/templates/menu-lateral-anunciante.jsp"/>      

            <div class="row container nav-breadcrumb">                             
                <div class="col s12 l12 m12 links">
                    <a href="<c:url value="/anunciante/home"/>" class="breadcrumb link-anterior">Home</a>                                                                  
                    <a href="<c:url value="/anunciante/mensagem/list"/>" class="breadcrumb link-anterior">Conversas</a>                                                                  
                    <a href="#!" class="breadcrumb link-ativo">Chat</a>
                </div>                                        
            </div>
            <div class="linha"></div>

            <div class="container">
                <div class="titulo">
                    <h6>Chat com ${parceiroChat.nome}</h6>
                    <h6>Item ${mensagem.item.nome}</h6>
                </div>
                <div class="mensagens">
                    <div class="card-title">Mensagens</div>
                    <%--<c:forEach items="${mensagemList}" var="mensagens">--%>
                    <!--<div class="mensagem">-->
                        <!--<span>${mensagens.remetente.nome}: ${mensagens.texto}</span>-->
                    <!--</div>-->
                    <%--</c:forEach>--%>
                    <div ng-repeat="mensagens in mensagemList| orderBy:'data_hora_envio'">
                        <div class="mensagem">
                            <span>{{mensagens.remetente.nome}}: {{mensagens.texto}}</span>
                        </div>
                    </div>
                </div>
                <form class="col s12 formulario" method="post">
                    <div class="card-title">Nova mensagem</div>
                    <div class="row">
                        <div class="input-field col s12">
                            <textarea id="texto" name="texto" class="materialize-textarea texto" placeholder="Digite a mensagem aqui" ng-model="mensagem.texto"></textarea>                                            
                        </div>
                    </div>
                    <div class="row">
<!--                    <a class="waves-effect waves-light btn grey darken-3 right btn-large" href="<c:url value="/anunciante/pesquisar/item/${item.id}/view"/>">Cancelar</a>-->
                        <button ng-click="enviarMensagem(mensagem)" class="waves-effect waves-light btn-large btn blue right" style="margin-right: 0.6rem;">Enviar</button>
                    </div>
                </form>
            </div>
        </header>
    </body>
</html>
