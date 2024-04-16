//import logo from './logo.svg';
import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [kogus, setKogus] = useState(0); // HTMLs esinevad muutujad peavad olema useState sees
  const [entities, setEntities] = useState([]);
  const nameRef = useRef();
  const descriptionRef = useRef();
  const numberRef = useRef();
  const [numbercomponents, setNumbercomponents] = useState([]);


  // Reacti hookid: use eesliidesega, neid peab importima. Reacti erikood
  // Springis annotatsioonid: @RestController, @GetMapping. neid peab importima. Springi erikood.

  useEffect(() => {
    fetch("http://localhost:8080/numbercomponents")
      .then(response => response.json()) // koos metadataga (headerid, staatuskood, OK)
      .then(json => {
        setNumbercomponents(json);
      }) // body
  }, []);

  // uef -> JS: onLoad()
  useEffect(() => {
    fetch("http://localhost:8080/api/entities")
      .then(response => response.json()) // koos metadataga (headerid, staatuskood, OK)
      .then(json => {
        setKogus(json.length);
        setEntities(json);
      }) // body
  }, []);

  function kustuta(primaarivoti) {
    fetch("http://localhost:8080/api/entities/" + primaarivoti, {"method": "DELETE"})
      .then(response => response.json()) 
      .then(json => {
        setKogus(json.length);
        setEntities(json);
      })
  }

  function kustutaNC(primaarivoti) {
    fetch("http://localhost:8080/numbercomponents/" + primaarivoti, {"method": "DELETE"})
      .then(response => response.json()) 
      .then(json => {
        setNumbercomponents(json)
      })
  }

  const nrNameRef =useRef();
  const kogusRef =useRef();

  function lisaNC() {
    const lisatavNC = {
      "number": {"name": nrNameRef.current.value},
      "kogus": kogusRef.current.value
    }
    fetch("http://localhost:8080/numbercomponents", {
      "method": "POST",
      "body": JSON.stringify(lisatavNC),
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json()) 
      .then(json => {
        setNumbercomponents(json)
      })
  }

  function lisa() {
    // document.getElemenyById("sad").value -> guugeldada see vs useRef
    if (nameRef.current.value.trim() === "") {
      return;
    }
    const entity = {
      "name": nameRef.current.value,
      "description": descriptionRef.current.value,
      "number": numberRef.current.value,
    }
    fetch("http://localhost:8080/api/entities", 
    {
      "method": "POST", 
      "body": JSON.stringify(entity), 
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json()) 
      .then(json => {
        setKogus(json.length);
        setEntities(json);
      })
  }

  return (
    <div className="App">
      Mul on {kogus} asi/asja
      <br /><br />
      
      <label>Asja nimetus</label> <br/>
      <input ref={nameRef} type="text" /> <br />
      <label>Asja kirjeldus</label> <br/>
      <input ref={descriptionRef} type="text" /> <br />
      <label>Number</label> <br/>
      <input ref={numberRef} type="text" /> <br />
      <button onClick={() => lisa()}>Sisesta</button> <br />
      <br />

      {entities.map(t => <div>{t.name} | {t.description} | {t.number} | <button onClick={() => kustuta(t.name)}>x</button> </div> )}
      <hr />
      <label>Numbri nimetus (Täpne nimetus andmebaasist)</label> <br/>
      <input ref={nrNameRef} type="text" /> <br />
      <label>Kogus</label> <br/>
      <input ref={kogusRef} type="text" /> <br />
      <button onClick={() => lisaNC()}>Sisesta</button> <br />

      {numbercomponents.map(tk => <div>{tk.id} | {tk.number?.name} | {tk.kogus} | <button onClick={() => kustutaNC(tk.id)}>x</button> </div> )}
    </div>
  );
}

export default App;