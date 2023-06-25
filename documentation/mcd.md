# Model Conceptuel des Données pour Heroes of Transnya

Pour éviter de trop charger le MCD, les identifiants ne sonts pas représentés et sont donc implicite pour chaque classe (sauf les healthpoint ou y a pas d'id vu que c'est du *1,1* des deux coté)

```
                  +---------+
                  |  Party  |
                  +---------+
                  | name    |
                  +---------+
            1,N  /           \ 0,N
                /             \
    (est possédé par)      (est composée de)
              /                 \
         0,N /                   \ 0,N
      +----------+                +-----------+
      | User     |                | Character |
      +----------+0,N          1,1+-----------+
      | email    |---(stock des)--| name      |
      | password |                | element   |
      +----------+                | imagePath |
                                  | level     |
                                  +-----------+
                              1,1/      |0,N   \ 0,N
                          (vie avec)    |    (peut uitliser)
                            1,1/        |        \ 1,N
                      +-------------+   |    +-------------+
                      | HealthPoint |   |    | Skill       |
                      +-------------+   |    +-------------+
                      | current     |   |    | name        |
                      | max         |   |    | description |
                      +-------------+   |    | imagePath   |
                                        |    +-------------+
                                        |
                                  (peut utiliser)
                                        |1,1
                                  +-------------+
                                  | Item        |
                                  +-------------+
                                  | name        |
                                  | description |
                                  | imagePath   |
                                  +-------------+
```
