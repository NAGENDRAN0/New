import { useEffect, useState } from "react";
import style from "./Search.module.css";
const URL = "https://api.spoonacular.com/recipes/complexSearch";
const API_KEY = "00f87bb9354a490fbba4f4ee55733db3";

export default function Search({ foodData, setFoodData }) {
  const [query, setQuery] = useState("pizza");
  useEffect(() => {
    async function fetchFood() {
      const res = await fetch(`${URL}?query=${query}&apiKey=${API_KEY}`);
      const data = await res.json();
      console.log(data);
      setFoodData(data.results);
    }
    fetchFood();
  }, [query]);
  return (
    <div className={style.searchContainer}>
      <input
        className={style.input}
        value={query}
        onChange={(e) => setQuery(e.target.value)}
        type="text"
      />
    </div>
  );
}
