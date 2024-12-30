const person = {
    firstName: 'Bob',
    lastName: 'Smith',
    address: {
        city: 'New York',
        state: 'NY'
    },
    profiles: ['LinkedIn', 'Twitter', 'Facebook'],
    printProfile: () => {
        return person.profiles.map(
            profile => {
                return <li key={profile}>{profile}</li>
            });
    }
};

export default function LearningJavaScript() {
    return (
        <div>
            <h1>Learning JavaScript</h1>
            <p>{person.firstName} lives in: {person.address.city}</p>
            <p>Profiles:</p>
            <ul>
                {person.printProfile()}
            </ul>
        </div>
    );
}