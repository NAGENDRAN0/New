import style from "./FoodItem.module.css";

export default function FoodItem({ food, setFoodId }) {
  return (
    <div className={style.card}>
      <img className={style.item} src={food.image} alt="" />
      <div className={style.itemContent}>
        <p className={style.itemName}>{food.title}</p>
      </div>
      <div className={style.buttonContent}>
        <button onClick={() => setFoodId(food.id)} className={style.itemButton}>
          View Recipe
        </button>
      </div>
    </div>
  );
}
