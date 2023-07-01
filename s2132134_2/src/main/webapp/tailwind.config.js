/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./*.{html,jsp}"],
  theme: {
    extend: {},
  },
  plugins: [require("daisyui")],
  daisyui: {
    themes: ["light"],
  },
}

