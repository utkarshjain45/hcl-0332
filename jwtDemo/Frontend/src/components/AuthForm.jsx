
import { useActionState, useState } from "react";
import api from "../api/api.js";
import SubmitButton from "./SubmitButton";

const AuthForm = ({ onLogin }) => {
  const [mode, setMode] = useState("login");

  const submitAction = async (prevState, formData) => {
    const userName = formData.get("userName")?.trim();
    const password = formData.get("password");

    if (!userName || !password) {
      return {
        error: "Username and password are required.",
        msg: "",
        userName: userName || "",
      };
    }

    try {
      if (mode === "register") {
        await api.post("/auth/register", { userName, password });

        setMode("login");

        return {
          error: null,
          msg: "Account created successfully! Please login.",
          userName,
        };
      }

      const { data } = await api.post("/auth/login", {
        userName,
        password,
      });

      localStorage.setItem("token", data.token);
      localStorage.setItem("userName", data.userName);

      onLogin?.(data.userName);

      return {
        error: null,
        msg: "",
        userName: data.userName,
      };

    } catch (error) {
      return {
        error:
          error.response?.data?.error ||
          error.response?.data?.message ||
          "Something went wrong. Please try again.",
        msg: "",
        userName,
      };
    }
  };

  const [state, formAction, isPending] = useActionState(
    submitAction,
    {
      error: null,
      msg: "",
      userName: "",
    }
  );

  return (
    <div className="w-full max-w-md mx-auto">
      <form
        action={formAction}
        className="w-full space-y-5 rounded-2xl border border-gray-200 bg-white p-6 shadow-xl sm:p-8"
      >
        {/* Heading */}
        <div className="text-center space-y-2">
          <h3 className="text-3xl font-bold tracking-tight text-gray-900">
            {mode === "login" ? "Welcome Back" : "Create Account"}
          </h3>

          <p className="text-sm text-gray-500">
            {mode === "login"
              ? "Login to continue to your account"
              : "Register to get started"}
          </p>
        </div>

        {/* Username */}
        <div className="space-y-2">
          <label
            htmlFor="userName"
            className="block text-sm font-semibold text-gray-700"
          >
            Username
          </label>

          <input
            type="text"
            name="userName"
            id="userName"
            placeholder="Enter your username"
            defaultValue={state.userName}
            autoComplete="username"
            required
            disabled={isPending}
            className="w-full rounded-lg border border-gray-300 bg-gray-50 px-4 py-3 text-gray-900 outline-none transition-all placeholder:text-gray-400 focus:border-blue-500 focus:bg-white focus:ring-4 focus:ring-blue-100 disabled:cursor-not-allowed disabled:opacity-60"
          />
        </div>

        {/* Password */}
        <div className="space-y-2">
          <label
            htmlFor="password"
            className="block text-sm font-semibold text-gray-700"
          >
            Password
          </label>

          <input
            type="password"
            name="password"
            id="password"
            placeholder="Enter your password"
            autoComplete={
              mode === "login" ? "current-password" : "new-password"
            }
            required
            disabled={isPending}
            className="w-full rounded-lg border border-gray-300 bg-gray-50 px-4 py-3 text-gray-900 outline-none transition-all placeholder:text-gray-400 focus:border-blue-500 focus:bg-white focus:ring-4 focus:ring-blue-100 disabled:cursor-not-allowed disabled:opacity-60"
          />
        </div>

        {/* Submit Button */}
        <SubmitButton />

        {/* Switch Mode */}
        <div className="text-center">
          <button
            type="button"
            disabled={isPending}
            onClick={() => setMode(mode === "login" ? "register" : "login")}
            className="text-sm font-medium text-blue-600 transition-colors hover:text-blue-800 hover:underline disabled:cursor-not-allowed disabled:opacity-50"
          >
            {mode === "login"
              ? "Don't have an account? Register"
              : "Already have an account? Login"}
          </button>
        </div>

        {/* Success Message */}
        {state.msg && (
          <p
            role="status"
            className="rounded-lg border border-green-200 bg-green-50 px-4 py-3 text-center text-sm font-medium text-green-700"
          >
            {state.msg}
          </p>
        )}

        {/* Error Message */}
        {state.error && (
          <p
            role="alert"
            className="rounded-lg border border-red-200 bg-red-50 px-4 py-3 text-center text-sm font-medium text-red-600"
          >
            {state.error}
          </p>
        )}
      </form>
    </div>
  );
};

export default AuthForm;
