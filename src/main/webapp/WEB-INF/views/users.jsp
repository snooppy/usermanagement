<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf8">
        <title><spring:message code="label.title" /></title>
    </head>
    <body>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h4>
                Login as : ${pageContext.request.userPrincipal.name}
            </h4>
        </c:if>
        <a href="<c:url value="/logout" />">
            <spring:message code="label.logout" />
        </a>

        <h2><spring:message code="label.title" /></h2>

        <form:form method="post" action="add" commandName="user">
            <table>
                <tr>
                    <td><form:label path="firstname">
                            <spring:message code="label.firstname" />
                        </form:label>
                    </td>
                    <td><form:input path="firstname" /></td>
                </tr>
                <tr>
                    <td><form:label path="lastname">
                            <spring:message code="label.lastname" />
                        </form:label>
                    </td>
                    <td><form:input path="lastname" /></td>
                </tr>
                <tr>
                    <td><form:label path="email">
                            <spring:message code="label.email" />
                        </form:label>
                    </td>
                    <td><form:input path="email" /></td>
                </tr>             
                <tr>
                    <td colspan="2"><input type="submit"
                                           value="<spring:message code="label.adduser"/>" />
                    </td>
                </tr>
            </table>
        </form:form>

        <h3><spring:message code="label.users" /></h3>
        <c:if test="${!empty userList}">
            <table border="1">
                <tr>
                    <th><spring:message code="label.firstname" /></th>
                    <th><spring:message code="label.lastname" /></th>
                    <th><spring:message code="label.email" /></th>
                     <th><spring:message code="label.role" /></th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td>${user.firstname}</td>
                        <td>${user.lastname}</td>
                        <td>${user.email}</td>
                        <td>${user.role}</td>
                        <td><a href="delete/${user.id}"><spring:message code="label.delete" /></a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

    </body>
</html>