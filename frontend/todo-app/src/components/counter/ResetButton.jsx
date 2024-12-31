import PropTypes from 'prop-types';
import './ResetButton.css'

export default function ResetButton({ resetMethod }) {
    function reset() {
        resetMethod();
    }

    return(
        <div>
            <button className="resetButton" onClick={reset}>Reset</button>
        </div>
    )
}

ResetButton.propTypes = {
    resetMethod: PropTypes.func
}