# REST API

**Load crossroads**
* **URL**

  /crossroad/all

* **Method:**

  `GET`
* **Success Response:**
  * **Code:** 200 <br />
    **Content:** `[
                     {
                       "id": 1,
                       "semaphores": [
                         {
                           "id": 1,
                           "color": "GREEN",
                           "position": "UP",
                           "sensor": {
                             "id": 1,
                             "active": false
                           },
                           "button": {
                             "id": 1
                           }
                         }
                       ]
                     }
                  ]`

**Load crossroad**
* **URL**

  /crossroad/id

* **Method:**

  `GET`
* **Success Response:**
  * **Code:** 200 <br />
    **Content:** `  {
                      "id": 1,
                      "semaphores": [
                        {
                          "id": 1,
                          "color": "GREEN",
                          "position": "UP",
                          "sensor": {
                            "id": 1,
                            "active": false
                          },
                          "button": {
                            "id": 1
                          }
                        }
                      ]
                    }`
  


**Load buttons**
* **URL**

  /button/all

* **Method:**

  `GET`
* **Success Response:**
  * **Code:** 200 <br />
    **Content:** `[{"id":1},{"id":2},{"id":7},{"id":8}]`



**Click button**
* **URL**

  /button/click/id

* **Method:**

  `POST`
* **Success Response:**
  * **Code:** 200 <br />
    **Return:** Updated cross road <br /> 
    **Content:** `[
                                       {
                                         "id": 1,
                                         "semaphores": [
                                           {
                                             "id": 1,
                                             "color": "GREEN",
                                             "position": "UP",
                                             "sensor": {
                                               "id": 1,
                                               "active": false
                                             },
                                             "button": {
                                               "id": 1
                                             }
                                           }
                                         ]
                                       }
                                    ]`
  

**Load semaphores**
* **URL**

  /semaphore/all

* **Method:**

  `GET`
* **Success Response:**
  * **Code:** 200 <br />
    **Content:** `[
                      {
                          "id": 1,
                          "color": "GREEN",
                          "position": "UP",
                          "sensor": {
                              "id": 1,
                              "active": false
                          },
                          "button": {
                              "id": 5
                          }
                      }
                  ]`



**Load sensors**
* **URL**

  /sensor/all

* **Method:**

  `GET`
* **Success Response:**
  * **Code:** 200 <br />
    **Content:** `[
                      {
                          "id": 1,
                          "active": false
                      },
                      {
                          "id": 2,
                          "active": false
                      }
                  ]`

**Load sensor**
* **URL**

  /sensor/id

* **Method:**

  `GET`
* **Success Response:**
  * **Code:** 200 <br />
    **Content:** `
                      {
                          "id": 1,
                          "active": false
                      }
                  `

**Sensor action**
* **URL**

  /sensor/action/id

* **Method:**

  `POST`
* **Success Response:**
  * **Code:** 200 <br />
     **Return:** Updated cross road <br /> 
        **Content:** `[
                                           {
                                             "id": 1,
                                             "semaphores": [
                                               {
                                                 "id": 1,
                                                 "color": "GREEN",
                                                 "position": "UP",
                                                 "sensor": {
                                                   "id": 1,
                                                   "active": false
                                                 },
                                                 "button": {
                                                   "id": 1
                                                 }
                                               }
                                             ]
                                           }
                                        ]`
      




