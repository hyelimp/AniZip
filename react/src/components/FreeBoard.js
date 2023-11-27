import React from "react";
import "../css/freeboard.css";



const FreeBoard = () => {
    return(
        <div className="Freeiframe">
            <iframe src="http://192.168.0.50/board/list?" width="100%" height="800vh">
            </iframe>
        </div>
    );
};
export default FreeBoard;