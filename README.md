# Recipe Finder

##### Android App To Find Recipes with Ingredients On Hand, 4/22/2016

#### By Michelle Brecunier

## Description

This Android application allows users to enter ingredients that they have in their kitchen to get customized recipe results. Currently the recipes are hardcoded in and not specific to a user's search. This app will eventually use the Food2Fork API to search for recipes and provide links to the directions. Users will also be able to make a shopping list out of the items they do not currently have.

## Setup/Installation Requirements
You will need the following programs installed on your computer.
* Android Studio
* Java JDK 8+
* Android SDK

### To Run
* In a terminal window, navigate to ~/AndroidStudioProjects
* Run `git clone https://github.com/mbrecunier/RecipeFinder.git`
* Navigate to ~/AndroidStudioProjects/RecipeFinder
* Run on either an emulator or an Android OS Device connected to a computer

##### To set up an emulator
* Select Run > Run 'app'
* Click 'Create New Emulator'
* Select the device you would like to emulate (Recommended: Nexus 6)
* Select the API level you would like to run - click 'Download' if not available (Recommended: Marshmallow - ABI: x86)
* Select configuration settings for emulator
* Click 'Finish' and allow Emulator to run

## Technologies Used

Java, Android Studio, testing with Robolectric and Espresso

### Legal

Copyright (c) 2016 Michelle Brecunier

This software is licensed under the MIT license.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
