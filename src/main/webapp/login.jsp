<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Student Login</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

    <div class="auth-container">

        <div class="auth-box">

            <h1>Student Login</h1>

            <p class="auth-subtitle">
                Login to your student account
            </p>

            <form action="LoginServlet" method="post">

                <label>Email</label>
                <input type="email"
                       name="email"
                       placeholder="Enter your email"
                       required>

                <label>Password</label>
                <input type="password"
                       name="password"
                       placeholder="Enter your password"
                       required>

                <button type="submit">
                    Login
                </button>

            </form>

            <p class="auth-footer">
                Don't have an account?
                <a href="register.jsp">Create Account</a>
            </p>

            <p class="auth-footer">
                <a href="index.html">← Back to Home</a>
            </p>

        </div>

    </div>

</body>

</html>