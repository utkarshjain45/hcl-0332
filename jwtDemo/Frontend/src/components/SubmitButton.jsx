
import { useFormStatus } from "react-dom";

const SubmitButton = () => {
  const { pending } = useFormStatus();

  return (
    <button
      type="submit"
      disabled={pending}
      className="flex w-full items-center justify-center gap-2 rounded-lg bg-blue-600 px-4 py-3 font-semibold text-white shadow-md transition-all duration-200 hover:bg-blue-700 active:scale-[0.98] disabled:cursor-not-allowed disabled:opacity-60"
    >
      {pending ? (
        <>
          <span className="h-5 w-5 animate-spin rounded-full border-2 border-white/30 border-t-white" />
          Submitting Securely...
        </>
      ) : (
        "Submit"
      )}
    </button>
  );
};

export default SubmitButton;
