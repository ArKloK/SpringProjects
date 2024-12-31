import PropTypes from 'prop-types';
import './CounterButton.css'

export default function CounterButton({ by = 1 , incrementMethod, decrementMethod}) {

    return (
        <div className="counter">
            <button className="counterButton"
                onClick={() => incrementMethod(by)}
            >+{by}</button>
            <button className="counterButton"
                onClick={() => decrementMethod(by)}
            >-{by}</button>
        </div>
    )

}

CounterButton.propTypes = {
    by: PropTypes.number,
    incrementMethod: PropTypes.func,
    decrementMethod: PropTypes.func
}