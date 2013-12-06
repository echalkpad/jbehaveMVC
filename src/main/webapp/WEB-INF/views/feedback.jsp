<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Feedback</title>
</head>
<body>
<h1>
    Submit Feedback
</h1>

<form:form id="feedbackGivingForm" modelAttribute="feedbackForm">
    <tr>
        <td> Giver's Name:</td>
        <td><form:input path="myName"/></td>
    </tr>
    <tr>
        <td> Receiver's Name:</td>
        <td><form:input path="recipientName"/></td>
    </tr>
    <tr>
        <td> Feedback:</td>
        <td><form:input path="feedbackMessage"/></td>
    </tr>
    <tr>
        <td><input id="submitFeedback" type="submit" value="Submit"></td>
    </tr>
</form:form>

<h1>
    Previous Feedback
</h1>

<c:forEach var="feedbackItem" items='${feedbackServiceL}'>
    <div><span>Giver's Name: </span><span id="myNameView">${feedbackItem.giversName}</span></div>

    <div><span>Receiver's Name: </span><span id="recipientNameView">${feedbackItem.recipientName}</span></div>

    <div><span>Feedback: </span><span id="feedbackMessageView">${feedbackItem.feedbackMessage}</span></div>
    <br>
</c:forEach>

</body>
</html>