
import { useActionState } from "react";
import SubmitButton from "./SubmitButton";
import api from "../api/api.js";

const PostForm = ({ onCreated }) => {
  const submitAction = async (prev, formData) => {
    const title = formData.get("title")?.trim();
    const content = formData.get("content")?.trim();

    if (!title || !content) {
      return {
        error: "Title and content are required.",
        msg: "",
        title: title || "",
        content: content || "",
      };
    }

    try {
      await api.post("/posts", { title, content });
      await onCreated?.();

      return {
        error: null,
        msg: "Post created successfully!",
        title: "",
        content: "",
      };
    } catch (error) {
      return {
        error:
          error.response?.data?.error ||
          error.response?.data?.message ||
          "Failed to create post. Please try again.",
        msg: "",
        title,
        content,
      };
    }
  };

  const [state, formAction, isPending] = useActionState(
    submitAction,
    {
      error: null,
      msg: "",
      title: "",
      content: "",
    }
  );

  return (
    <div className="w-full max-w-2xl mx-auto">
      <form
        action={formAction}
        className="w-full space-y-5 rounded-2xl border border-gray-200 bg-white p-6 shadow-xl sm:p-8"
      >
        {/* Header */}
        <div className="space-y-2">
          <h3 className="text-2xl font-bold tracking-tight text-gray-900">
            Write a Post
          </h3>
          <p className="text-sm text-gray-500">
            Share your thoughts and ideas with everyone.
          </p>
        </div>

        {/* Title */}
        <div className="space-y-2">
          <label
            htmlFor="title"
            className="block text-sm font-semibold text-gray-700"
          >
            Post Title
          </label>

          <input
            type="text"
            name="title"
            id="title"
            placeholder="Enter an interesting title..."
            defaultValue={state.title}
            required
            disabled={isPending}
            className="w-full rounded-lg border border-gray-300 bg-gray-50 px-4 py-3 text-gray-900 outline-none transition-all placeholder:text-gray-400 focus:border-blue-500 focus:bg-white focus:ring-4 focus:ring-blue-100 disabled:cursor-not-allowed disabled:opacity-60"
          />
        </div>

        {/* Content */}
        <div className="space-y-2">
          <label
            htmlFor="content"
            className="block text-sm font-semibold text-gray-700"
          >
            Content
          </label>

          <textarea
            name="content"
            id="content"
            placeholder="What's on your mind?"
            rows={5}
            defaultValue={state.content}
            required
            disabled={isPending}
            className="w-full resize-y rounded-lg border border-gray-300 bg-gray-50 px-4 py-3 text-gray-900 outline-none transition-all placeholder:text-gray-400 focus:border-blue-500 focus:bg-white focus:ring-4 focus:ring-blue-100 disabled:cursor-not-allowed disabled:opacity-60"
          />
        </div>

        {/* Submit */}
        <SubmitButton />

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

export default PostForm;
