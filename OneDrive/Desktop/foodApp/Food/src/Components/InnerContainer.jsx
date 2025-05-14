import style from "./InnerContainer.module.css";
export default function InnerContainer({ children }) {
  return <div className={style.innerContainer}>{children}</div>;
}
