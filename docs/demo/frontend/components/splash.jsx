import React from 'react';
import { Button } from 'react-bootstrap';

export default class Splash extends React.Component {
  constructor(props) {
    super(props);
    this.state = {displayMap: false};
    this.smoothScroll = this.smoothScroll.bind(this);
  }

  smoothScroll(h) {
    let i = h || 0;
    if (i < 1000) {
      setTimeout(() => {
        window.scrollTo(0, i);
        this.smoothScroll(i + 30);
      }, 1);
    }
  }

  render() {
    return (
      <div className="splash">
        <div className="splash-text">
        <h2>
          Plan your Trip.
        </h2>
        <p>Discover hidden gems along the way.</p>
        <br />

        </div>
        <button
          onClick={ () => window.scrollTo(0, document.body.scrollHeight / 3) }
          className="splash-button"
          >Read more</button>
        <div className="splash_phone">
          <img
            src="https://res.cloudinary.com/trwong/image/upload/v1517120829/splash_iphone_imwrpb.png"
            alt="emulator"/>
        </div>
      </div>
    );
  }
}
