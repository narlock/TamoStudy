/**
 * @author Anthony Narlock
 * @breif TamoStudy Web Demo Version 2 on anthonynarlock.com
 */

//Constant for month
 const months = [
    "Jan",
    "Feb",
    "Mar",
    "Apr",
    "May",
    "Jun",
    "Jul",
    "Aug",
    "Sep",
    "Oct",
    "Nov",
    "Dec",
];

//Const for seconds
const seconds = [60,300,900,1500,3000,3600];

//Sets Date - current date
let curDate = new Date();
const year = curDate.getFullYear();
const month = curDate.getMonth();
const date = curDate.getDate();
document.getElementById("joinDate").innerHTML = "<strong>Join Date: </strong>" + year + "-" + months[month] + "-" + date;

//Set default values for happy/hunger
let happiness = 5;
let hunger = 5;
document.getElementById("tamoHappiness").innerHTML = "<strong>Happiness: </strong>" + happiness;
document.getElementById("tamoHunger").innerHTML = "<strong>Hunger: </strong>" + hunger;

let totalTime = 0;
document.getElementById("totalTime").innerHTML = "<strong>Total Focus Time: </strong>" + totalTime + " mins";

/*
Set up countdown timer
For the beginning, this will just be a simple countdown from 60 minutes
After the 60 minutes, the total Hours will update 
*/

var Timer = function(opts) {
    var self = this;
  
    self.opts     = opts || {};
    self.element  = opts.element || null;
    self.minutes  = opts.minutes || 0;
    self.seconds  = opts.seconds || 30;
  
    self.start = function() {
      self.interval = setInterval(countDown, 1000);
    };
  
    self.stop = function() {
      clearInterval(self.interval);
      endCountdown();
    };
  
    function countDown() {
        self.seconds--; //Changed Line
        if (self.minutes == 0 && self.seconds == 0) {
          self.stop();
        }
    
        if (self.seconds < 0) { //Changed Condition. Not include 0
          self.seconds = 59;
          self.minutes--;
        }
    
        if (self.seconds <= 9) { self.seconds = '0' + self.seconds; }
    
        self.element.textContent = self.minutes + ' : ' + self.seconds;
      }

  };


let startButton = document.getElementById("start");
  function startCountdown() {
    let value = document.getElementById("setTime").value;
    console.log("value = " + value);
    startButton.disabled = true;
    console.log("Beginning session...");

    //one minute
    if(value == 0) {
        var myTimer = new Timer({
        minutes: 0,
        seconds: 60,
        element: document.querySelector('.time')
        });
    }
    //5 minute
    if(value == 1) {
            var myTimer = new Timer({
            minutes: 4,
            seconds: 60,
            element: document.querySelector('.time')
        });
    }

    //15 minute
    if(value == 2) {
    var myTimer = new Timer({
        minutes: 14,
        seconds: 60,
        element: document.querySelector('.time')
    });
    }

    //25 minute
    if(value == 3) {
        var myTimer = new Timer({
        minutes: 24,
        seconds: 60,
        element: document.querySelector('.time')
        });
    }
    
    //50 minute
    if(value == 4) {
        var myTimer = new Timer({
        minutes: 49,
        seconds: 60,
        element: document.querySelector('.time')
        });
    }

    //60 minute
    if(value == 5) {
        var myTimer = new Timer({
        minutes: 59,
        seconds: 60,
        element: document.querySelector('.time')
        });
    }

      myTimer.start();

}

function endCountdown() {
    startButton.disabled = false;
    let value = document.getElementById("setTime").value;
    totalTimeSeconds = seconds[parseInt(value)];
    totalTime = (totalTimeSeconds / 60);
    document.getElementById("totalTime").innerHTML = "<strong>Total Focus Time: </strong>" + totalTime + " mins";

    happiness++;
    document.getElementById("tamoHappiness").innerHTML = "<strong>Happiness: </strong>" + happiness;
}