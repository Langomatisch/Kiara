nick
=====
a simple way to nick your player

dependencies
------------

* **`none`**

config
------
* **`isLobby:`** **Used to see if the Nick command should work.**

commands
--------
* **`nick: `** **nicks you randomly or to a given name**

events
------
* **`PlayerNickEvent:`** **will be fired when the player nick/unnick**

permissions
-----------
* **`command.nick`** **nick the player if nick module is not on lobby mode**
* **`command.nick.bypass`** **sees all other users as original user**

how to use
----------
```
NickUser nickUser = NickUser.getNickUser(player);
// nick or unnick the player depending on the current state
nickUser.nick(nickname);
```
