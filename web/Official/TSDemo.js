/*
@author: Anthony Narlock
@desc: TamoStudyDemo on anthonynarlock.com

Please note: This is my first JavaScript project. I am completely self-taught.
*/

/*
Variables
*/

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

const totalHours = document.querySelector('.totalHours');
const joinDate = document.querySelector('.joinDate');

const setTime = document.getElementById('setTimer');
var value = setTime.value;

var breakButton = document.getElementById('break');
breakButton.disabled = true;

var startButton = document.getElementById('start');
startButton.disabled = false;

//var display = document.querySelector('.time');
var totalTamoHours = 0;
var timerActive = false;

/* 
Setting up the Join Date: Simply will just use the current date.
*/
let newDate = new Date();

const year = newDate.getFullYear();
const month = newDate.getMonth();
const date = newDate.getDate();

joinDate.textContent = `Join Date: ${year}-${months[month]}-${date}`;



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

function startCountdown() {
    startButton.disabled = true;
    console.log("Beginning 60 minute session...");

     if(value == 0) {
      var myTimer = new Timer({
        minutes: 59,
        seconds: 60,
        element: document.querySelector('.time')
      });
    }

      if(value == 1) {
        var myTimer = new Timer({
          minutes: 0,
          seconds: 5,
          element: document.querySelector('.time')
        });
      }

      if(value == 2) {
          var myTimer = new Timer({
            minutes: 4,
            seconds: 60,
            element: document.querySelector('.time')
          });
        }

      myTimer.start();

}

function endCountdown() {
    startButton.disabled = false;
    console.log("You studied for 60 minutes!")
    totalTamoHours++;
    totalHours.textContent = `Total Hours: ${totalTamoHours}`;

}

function printSelectedTime() {
  value = setTime.value;
  console.log("value = " + value);

}
