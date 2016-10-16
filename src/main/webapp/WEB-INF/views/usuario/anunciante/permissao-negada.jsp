<%-- 
    Document   : permissao-negada
    Created on : 20/09/2016, 11:32:11
    Author     : Joao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Permissão Negada</title>
        <!--CSS BASE-->
        <jsp:include page="/resources/css/bases/css/base-style.jsp"/>

        <!--SCRIPTS-->
        <!--JS BASE-->
        <jsp:include page="/resources/css/bases/js/base-script.jsp"/>
    </head>
    <body style="background-color: #b0bec5;">
        <header>
            <jsp:include page="/resources/templates/menu-lateral-anunciante.jsp"/>
            
            <div class="row" style="padding-left: 15%; padding-right: 15%;">
                <div class="row">
                <nav class="grey darken-3 card-panel col s12 z-depth-2">
                    <div class="nav-wrapper">
                        <div class="col s12">
                            <a href="/web/anunciante/home" class="breadcrumb">Home</a>                            
                            <a href="#!" class="breadcrumb">Permissão Negada</a>
                        </div>                        
                    </div>
                </nav>
                </div>
                <div class="card-panel" style="margin-top: -2%;">
                    <div class="card-content">
                        <div class="card-title center" style="text-transform: uppercase;"><strong>Você não possui permissão para acessar esta área!</strong></div>
                        <div class="divider"></div>
                        <br/>
                        <div class="card-image responsive-img center"><img src="<c:url value="/resources/img/erros-e-descricoes1.png"/>"></div>
                    </div>
                </div>
            </div>
        </header>
    </body>
</html>
