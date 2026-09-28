<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

    <div class="auth-container">

        <div class="auth-box">

            <h1>Admin Login</h1>

            <p class="auth-subtitle">
                Login to the administrator account
            </p>

            <form action="AdminLoginServlet" method="post">

                <label>Username</label>

                <input type="text"
                       name="username"
                       placeholder="Enter admin username"
                       required>


                <label>Password</label>

                <input type="password"
                       name="password"
                       placeholder="Enter admin password"
                       required>


                <button type="submit">
                    Admin Login
                </button>

            </form>

            <p class="auth-footer">
                <a href="index.html">
                    ← Back to Home
                </a>
            </p>

        </div>

    </div>

</body>

</html>