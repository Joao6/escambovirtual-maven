<%-- 
    Document   : view
    Created on : 16/10/2016, 17:52:21
    Author     : Joao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Home</title>
        <!--CSS BASE-->
        <jsp:include page="/resources/css/bases/css/base-style.jsp"/>

        <link href="<c:url value="/resources/css/modulo-anunciante/base-style.css"/>" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="<c:url value="/resources/css/modulo-anunciante/home-anunciante.css"/>" type="text/css" rel="stylesheet" media="screen,projection"/>

        <!--SCRIPTS-->
        <!--JS BASE-->
        <jsp:include page="/resources/css/bases/js/base-script.jsp"/>

    </head>
    <body>
        <header>
            <jsp:include page="/resources/templates/menu-lateral-anunciante.jsp"/>

            <div class="row container nav-breadcrumb">                             
                <div class="col s12 l6 m6 links">
                    <a href="<c:url value="/anunciante/home"/>" class="breadcrumb link-anterior">Home</a>                                              
                    <a href="<c:url value="/anunciante/troca/list"/>" class="breadcrumb link-anterior">Trocas</a>                                              
                    <a href="<c:url value="#!"/>" class="breadcrumb link-anterior">Detalhes</a>                                              
                </div>                                        
            </div>
            <div class="linha"></div>

            <div class="container">
                <div class="conteudo">
                    <c:if test="${troca.oferta.item.anunciante.id eq anunciante.id}">
                        <h5>Você trocou o seu item <span>${troca.oferta.item.nome}</span></h5>
                        <h5>Pelos itens do 'anunciante' </h5>
                        <c:forEach items="${troca.oferta.ofertaItem.itemList}" var="item">
                            <h5>${item.nome}</h5>
                        </c:forEach>
                    </c:if>

                    <c:if test="${troca.oferta.item.anunciante.id != anunciante.id}">
                        <h5>Você trocou os seus itens</h5>
                        <c:forEach items="${troca.oferta.ofertaItem.itemList}" var="item">
                            <h5>${item.nome}</h5>
                        </c:forEach>
                        <h5>Pelo item ${troca.oferta.item.nome}</h5>
                    </c:if>
                </div>
            </div>
        </header>
    </body>
</html>
