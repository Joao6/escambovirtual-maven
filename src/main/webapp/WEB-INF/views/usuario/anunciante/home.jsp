<%-- 
    Document   : menu
    Created on : 20/05/2016, 14:24:13
    Author     : Joao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Home</title>
        <!--Import Google Icon Font-->
        <link href="<c:url value="/resources/css/icon.css"/>" rel="stylesheet">

        <link rel="shortcut icon" type="image/png" href="<c:url value="/resources/img/ico.png"/>"/>

        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/materialize.min.css"/>"  media="screen,projection"/>
        <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="<c:url value="/resources/css/ghpages-materialize.css"/>" type="text/css" rel="stylesheet" media="screen,projection"/>

        <link href="<c:url value="/resources/css/modulo-anunciante/base-style.css"/>" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="<c:url value="/resources/css/modulo-anunciante/home-anunciante.css"/>" type="text/css" rel="stylesheet" media="screen,projection"/>

        <!--SCRIPTS-->
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.1.min.js"/>"></script>        
        <script type="text/javascript" src="<c:url value="/resources/js/jquery.maskedinput.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/materialize.min.js"/>"></script>
        <script src="<c:url value="/resources/js/init.js"/>"></script>
    </head>

    <body>
        <header>
            <jsp:include page="/resources/templates/menu-lateral-anunciante.jsp"/>

            <div class="row container nav-breadcrumb">                             
                <div class="col s12 l6 m6 links">
                    <a href="<c:url value="/anunciante/home"/>" class="breadcrumb link-ativo">Home</a>                                              
                </div>                                        
            </div>
            <div class="linha"></div>
            
            <h5 class="title-info">Algumas informações da sua conta</h5>
            <c:if test="${countItem > 0}">
                <div class="row" style="margin-top: -2%;">
                    <div class="informacoes">
                        <div class="card-content">
                            <table class="striped">                                 
                                <!--<tr><td></td></tr>-->
                                <tr>
                                    <td><b>Itens cadastrados: </b>${countItem}</td>                                                    
                                </tr> 
                                <tr>
                                    <td><b>Ofertas recebidas: </b><c:if test="${not empty countOferta}">${countOferta}</c:if><c:if test="${empty countOferta}">Nenhuma até o momento</c:if></td>
                                    </tr>
                                    <tr>
                                        <td><b>Trocas realizadas: </b>Nenhuma até o momento</td>
                                    </tr>                                
                                </table>
                            </div>
                        </div>
                    </div>  
            </c:if>
            <c:if test="${countItem == 0}">
                <div class="row" style="margin-top: -2%;">
                    <div class="card-panel">
                        <div class="card-content">
                            <table class="bordered">
                                <tr>                                               
                                    <td colspan="4">
                                        <div class="card-title">                        
                                            <h5>Seja bem vindo(a)!</h5>                                                            
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td rowspan="4" class=""><img class="z-depth-2" src="<c:url value="/resources/img/cadastrar.png"/>" height="250" width="250"></td>
                                </tr>
                                <tr>
                                    <td><b>Você ainda não possui itens cadastrados</b></td>                                                    
                                </tr> 
                                <tr>
                                    <td><b>Cadastre itens para utilizar nossas funcionalidades</b></td>
                                </tr>
                                <tr>
                                    <td><a href="<c:url value="/anunciante/item/new"/>" class="btn blue center btn-large">Cadastrar Item</a></td>
                                </tr>                                
                            </table>
                        </div>
                    </div>
                </div>  
            </c:if>

        </header>
    </body>
</html>


