# Model du domaine actuel en base de données

On a 2 collection, les *perssonnages* (Character) et les *groupes de personnages* (Party). Étant donné que nous sommes en NoSQL, il n'y a pas de relations
entre les colléction et on peux observer des patrons comme la dénormalisation.

Pour ce qui est des utilisateurs (User), nous avons fait le choix de simuler un *provider* qui nous fournirai les utilisateurs.
Ainsi, nous n'avons pas à les stocker en base

```
+-------------------------+    +-------------------------------------------+
|        Character        |    |                   Party                   |
+-------------------------+    +-------------------------------------------+
| _id: ObjectID           |    | _id : ObjectID                            |
| name: String            |    | name : String                             |
| element: String         |    | owner.email : String                      |
| imagePath: String       |    | owner.username : String                   |
| skills: [skill]         |    | characters : [name, element, level, user] |
| items: [item  ]         |    +-------------------------------------------+
| party.name : String     |
| party._id               |
| user.email: String      |
| user.username: String   |
| user.roles:[Role]       |
| healthPoint.currnet:int |
| healthPoint.max : int   |
| level: int              |
+-------------------------+
```
