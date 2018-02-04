import React from 'react';
import NavHeader from './navheader';
import Splash from './splash';
import MeetTheTeam from './meet_team';
// import MapDisplay from './mapdisplay_container';
import About from './about';

const Landing = () => (
  <div className='landing'>
    <NavHeader />
    <Splash />
    <About />
    <MeetTheTeam />

  </div>
);

export default Landing;
