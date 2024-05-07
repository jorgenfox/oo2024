import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [kogus, setKogus] = useState(0); // HTMLs esinevad muutujad peavad olema useState sees
  const [riverinfo, setRiverInfo] = useState([]);
  const nimetusRef = useRef();
  const lahtmeXRef = useRef();
  const lahtmeYRef = useRef();
  const suudmeXRef = useRef();
  const suudmeYRef = useRef();
  const kiirusRef = useRef();

  useEffect(() => {
    fetch("http://localhost:8080/rivers")
      .then(response => response.json())
      .then(json => {
        setKogus(json.length);
        setRiverInfo(json);
      })
  }, []);

  function lisa() {
    // document.getElemenyById("sad").value -> guugeldada see vs useRef
    if (nimetusRef.current.value.trim() === "") {
      return;
    }
    const river = {
      "nimetus": nimetusRef.current.value,
      "lahtmeX": lahtmeXRef.current.value,
      "lahtmeY": lahtmeYRef.current.value,
      "suudmeX": suudmeXRef.current.value,
      "suudmeY": suudmeYRef.current.value,
      "kiirus": kiirusRef.current.value,
    }
    fetch("http://localhost:8080/rivers", 
    {
      "method": "POST", 
      "body": JSON.stringify(river), 
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json()) 
      .then(json => {
        setKogus(json.length);
        setRiverInfo(json);
      })
  }

  function kustuta(primaarivoti) {
    fetch("http://localhost:8080/rivers" + primaarivoti, {"method": "DELETE"})
      .then(response => response.json()) 
      .then(json => {
        setKogus(json.length);
        setRiverInfo(json);
      })
  }

    const [riverId, setRiverId] = useState('');
    const [distance, setDistance] = useState('');

    const handleChange = (event) => {
        setRiverId(event.target.value);
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        fetch(`http://localhost:8080/rivers/${riverId}/distance`)
        .then(response => {
            if (!response.ok) {
            throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            setDistance(data);
        })
        .catch(error => {
            console.error('Error fetching distance:', error);
        });
    };

    
    const [fastestRiver, setFastestRiver] = useState(null);
    const [slowestRiver, setSlowestRiver] = useState(null);
    
    useEffect(() => {
        const fetchFastestRiver = async () => {
        try {
            const response = await fetch('http://localhost:8080/rivers/fastest');
            if (!response.ok) {
            throw new Error('Failed to fetch fastest river');
            }
            const data = await response.json();
            setFastestRiver(data);
        } catch (error) {
            console.error(error);
        }
        };
    
        const fetchSlowestRiver = async () => {
        try {
            const response = await fetch('http://localhost:8080/rivers/slowest');
            if (!response.ok) {
            throw new Error('Failed to fetch slowest river');
            }
            const data = await response.json();
            setSlowestRiver(data);
        } catch (error) {
            console.error(error);
        }
        };
    
        fetchFastestRiver();
        fetchSlowestRiver();
    }, []);

  return (
    <div className="App">
      <div>
        <h2>Mul on {kogus} jõge</h2>
        <br /><br />
        
        <label>Jõe nimi</label> <br/>
        <input ref={nimetusRef} type="text" /> <br />
        <label>Jõe lähtme x koordinaat</label> <br/>
        <input ref={lahtmeXRef} type="text" /> <br />
        <label>Jõe lähtme y koordinaat</label> <br/>
        <input ref={lahtmeYRef} type="text" /> <br />
        <label>Jõe suudme x koordinaat</label> <br/>
        <input ref={suudmeXRef} type="text" /> <br />
        <label>Jõe suudme Y koordinaat</label> <br/>
        <input ref={suudmeYRef} type="text" /> <br />
        <label>Jõe kiirus</label> <br/>
        <input ref={kiirusRef} type="text" /> <br />
        <button onClick={() => lisa()}>Sisesta</button> <br />
        <br />

        {riverinfo.map(r => <div>{r.nimetus} | {r.lahtmeX} | {r.lahtmeY} | {r.suudmeX} | {r.suudmeY} | <button onClick={() => kustuta(r.nimetus)}>x</button> </div> )}
      </div>

      <div>
        <h2>Kalkuleeri jõe lähtme ja suudme kaugus</h2>
        <form onSubmit={handleSubmit}>
            <label>
            Sisesta jõe ID:
            <input type="text" value={riverId} onChange={handleChange} />
            </label>
            <button type="submit">Kalkuleeri</button>
        </form>
        {distance && (
            <p>
            Jõe lähtme ja suudme kaugus: {distance} pikslit
            </p>
        )}
      </div>

      <div>
        <h2>Jõgede kiirused</h2>
        <div>
            <h3>Kiireim jõgi</h3>
            {fastestRiver ? (
            <div>
                <p>Nimetus: {fastestRiver.nimetus}</p>
                <p>Koordinaadid - Lähe: ({fastestRiver.lahtmeX}, {fastestRiver.lahtmeY})  Suue: ({fastestRiver.suudmeX}, {fastestRiver.suudmeY})</p>
                <p>Kiirus: {fastestRiver.kiirus}</p>
            </div>
            ) : (
            <p>Laen kiireimat jõge...</p>
            )}
        </div>
        <div>
            <h3>Aeglaseim jõgi</h3>
            {slowestRiver ? (
            <div>
                <p>Nimetus: {slowestRiver.nimetus}</p>
                <p>Koordinaadid - Lähe: ({slowestRiver.lahtmeX}, {slowestRiver.lahtmeY}) Suue: ({slowestRiver.suudmeX}, {slowestRiver.suudmeY})</p>
                <p>Kiirus: {slowestRiver.kiirus}</p>
            </div>
            ) : (
            <p>Laen aeglaseimat jõge...</p>
            )}
      </div>
    </div>

    </div>
  );
  
}  

export default App;