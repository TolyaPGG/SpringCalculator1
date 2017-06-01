<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">

</head>
<body>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <h1>Calculator</h1>
        <sf:form action="/" method="post" modelAttribute="calculator">
            <c:if test="${calculator.previousOperation != null}">
                <p>Last Op: ${calculator.previousNumber}
                    <c:choose>
                        <c:when test="${calculator.previousOperation.equals('add')}">+</c:when>
                        <c:when test="${calculator.previousOperation.equals('subtract')}">-</c:when>
                        <c:when test="${calculator.previousOperation.equals('multiply')}">*</c:when>
                        <c:when test="${calculator.previousOperation.equals('divide')}">/</c:when>
                    </c:choose>
                </p>
            </c:if>
            <s:bind path="inputNumber">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <sf:input path="inputNumber" cssClass="form-control" placeholder="Enter"
                              autocomplete="off" autofocus="autofocus"/>
                    <sf:errors path="inputNumber" cssClass="help-block"/>
                </div>
            </s:bind>



            <sf:button type="submit" id="inputOperation" name="inputOperation" class="btn"
                       value="add">+</sf:button>
            <sf:button type="submit" id="inputOperation" name="inputOperation" class="btn"
                       value="subtract">-</sf:button>
            <sf:button type="submit" id="inputOperation" name="inputOperation" class="btn"
                       value="multiply">*</sf:button>
            <sf:button type="submit" id="inputOperation" name="inputOperation" class="btn"
                       value="divide">/</sf:button>
            <sf:button type="submit" id="inputOperation" name="inputOperation" class="btn btn-danger"
                       value="result">=</sf:button>
        </sf:form>
    </div>
</div>
</body>
<script src="<c:url value="/resources/js/jquery.min.js"/> "/>
<script src="<c:url value="/resources/js/bootstrap.min.js"/> "/>
</html>
