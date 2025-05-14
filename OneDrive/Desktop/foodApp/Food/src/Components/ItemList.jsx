import Item from "./Item";

export default function ItemList({ food, isLoading }) {
  return (
    <div>
      {isLoading ? (
        <p>loading</p>
      ) : (
        food.extendedIngredients.map((m) => <Item m={m} />)
      )}
    </div>
  );
}
