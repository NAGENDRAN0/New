import style from "./Item.module.css";
export default function Item({ m }) {
  return (
    <div>
      <div className={style.ItemContainer}>
        <div className={style.ImageContainer}>
          <img
            className={style.image}
            src={`https://spoonacular.com/cdn/ingredients_100x100/` + m.image}
            alt=""
          />
        </div>
        <div className={style.nameContainer}>
          <div className={style.name}>{m.name}</div>
          <div className={style.amount}>
            {m.amount} {m.unit}
          </div>
        </div>
      </div>
    </div>
  );
}
