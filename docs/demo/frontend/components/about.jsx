import React from 'react';

const About = () =>  {



    return (
      <div className="about">
        <h2 className="header">About</h2>
        <ul>
          <li><strong>TourGuide</strong> was designed with the  <strong>user</strong> in mind, we plan your trip, you have fun <strong>It's that simple</strong>.</li>
        </ul>
        <ul>
          <br />
          <div className='numberList'>
            <div>
              <h2 className='numberBig'>1</h2>
            </div>
            <div className='textBody'>
              <h2><strong>Tell us where you are.</strong></h2>
              <li><strong>TourGuide</strong> uses advanced AI natural language processing to determine what the user is requesting</li>
            </div>
          </div>
          <div className='numberList'>
            <div>
              <h2 className='numberBig'>2</h2>
            </div>
            <div className='textBody'>
              <h2><strong>Tell us where you want to go.</strong></h2>
              <li><strong>TourGuide</strong> only returns nearest relevant results.</li>
            </div>
          </div>
          <div className='numberList'>
              <h2 className='numberBig'>3</h2>
            <div className='textBody'>
              <div>
                <h2><strong>Thats it!</strong></h2>
                <li> Easily accessible, <strong>we plan for you</strong>. Sit back, relax, and enjoy your trip! </li>
              </div>
            </div>
          </div>
        </ul>
      </div>
    );

}
export default About;
