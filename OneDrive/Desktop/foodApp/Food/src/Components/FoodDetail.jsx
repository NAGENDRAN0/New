import { useEffect, useState } from "react";
import style from "./FoodDetail.module.css";
import ItemList from "./ItemList";
export default function FoodDetail({ foodId }) {
  const URL = `https://api.spoonacular.com/recipes/${foodId}/information`;
  const API_KEY = "00f87bb9354a490fbba4f4ee55733db3";
  const [food, setFood] = useState({});
  const [isLoading, setIsLoading] = useState(true);
  useEffect(() => {
    async function fetchFood() {
      const res = await fetch(`${URL}?apiKey=${API_KEY}`);
      const data = await res.json();
      console.log(data);
      setFood(data);
      setIsLoading(false);
    }
    fetchFood();
  }, [foodId]);
  // useEffect(() => {
  //   async function fetchFood() {
  //     try {
  //       const res = await fetch(`${URL}?apiKey=${API_KEY}`);

  //       // Check if the response is JSON
  //       const contentType = res.headers.get("content-type");
  //       if (!contentType || !contentType.includes("application/json")) {
  //         const text = await res.text();
  //         console.error("Expected JSON, but got:", text);
  //         return;
  //       }

  //       // Parse JSON if it's valid
  //       const data = await res.json();
  //       console.log(data);
  //     } catch (error) {
  //       console.error("Error fetching food data:", error);
  //     }
  //   }

  //   fetchFood();
  // }, []);

  return (
    <div>
      <div className={style.recipeCard}>
        <h1 className={style.recipeName}> {food.title}</h1>
        <img src={food.image} alt="" className={style.recipeImage} />
        <div className={style.recipeDetail}>
          <span>
            <strong>Ready in ⏲️ {food.readyInMinutes} Minutes </strong>
          </span>
          <span>
            <strong> 👨‍👩‍👦‍👦 serves - {food.servings}</strong>
          </span>
          <span>
            {" "}
            <strong>
              {food.vegetarian ? "🥕 Vegetarian" : "🍖 Non-vegetarian"}
            </strong>
          </span>
        </div>
        <div>
          <span>
            <strong>
              $ {Math.floor(food.pricePerServing / 100)} per serving
            </strong>
          </span>
        </div>
        <h2>Ingredients</h2>
        <ItemList food={food} isLoading={isLoading} />
        <h2>Instruction</h2>
        <div className={style.recipeInstruction}>
          <ol>
            {isLoading ? (
              <p>waiting</p>
            ) : (
              food.analyzedInstructions[0].steps.map((s) => (
                <li key={s.step}>{s.step}</li>
              ))
            )}
          </ol>
        </div>
      </div>
    </div>
  );
}
