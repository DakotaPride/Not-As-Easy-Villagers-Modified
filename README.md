<h1 align="center">Not As Easy Villagers</h1>
<p align="center">Reimplementation of <a href="https://github.com/henkelmax/easy-villagers">Easy Villagers</a>' villager item mechanic in Fabric.<br> You can combine this mod with <a href="https://www.curseforge.com/minecraft/mc-mods/trade-cycling">Trade Cycling</a> to get less cheaty Easy Villagers experience.</p>



<p align="center">
  <a title="Fabric API" href="https://github.com/FabricMC/fabric">
    <img src="https://i.imgur.com/Ol1Tcf8.png" width="151" height="50" />
  </a>
  <a title="Fabric Language Kotlin" href="https://github.com/FabricMC/fabric-language-kotlin" target="_blank" rel="noopener noreferrer">
    <img src="https://i.imgur.com/c1DH9VL.png" width="171" height="50" />
  </a>
</p>
<p align="center">
  <a href="https://github.com/igoro00/not-as-easy-villagers/actions"><img src="https://github.com/igoro00/not-as-easy-villagers/actions/workflows/build.yml/badge.svg"/></a>
  <a href="https://opensource.org/licenses/GPL-3.0"><img src="https://img.shields.io/badge/License-GPL%203.0-brightgreen.svg"></a>
</p>

## Check The Original Creator(s)!
Fabric Port: [Igoro00 Repo](https://github.com/igoro00/not-as-easy-villagers/)

Original Mod: [Henkelmax Curseforge](https://www.curseforge.com/minecraft/mc-mods/easy-villagers)


## Features
 - **Modified Addition**: ~~make a raid afraid of you by utterly destroying your pillager in an anvil, forcing a name change~~
 - **Modified Addition**: Shift-Right click a pillager (either normal or evoker) with an empty hand to ~~torture it~~ get the pillager item

## Contributing
(To the original project)

Feel free to contribute to this project(like, really. Please, contribute) by forking this repository and creating a pull request.

**I would especially appreciate helping with combining textures based on the profession, type and level of the villager.**

The model of the villager item(created in Blockbench, project file called `villager.bbmodel` is available in the main directory of the repo) already supports Minecraft's default textures for the villager. The texture in `src/main/resources/assets/not_as_easy_villagers/textures/item/villager.png` is actually just `villager.png` and `types/plains.png` from the default texture pack layered on top of each other in GIMP.

Now, all we need to do is to get VillagerData on item creation (in `MobEntityMixin.java`). Then, based on that, combine appropriate textures and apply it to the item dynamically(I couldn't do either as I'm very knew to Minecraft modding and Java in general). **If you know how to do it, please (at least) create an issue pointing me in the right direction.** 

**The reason why I didn't fork the project/pull request it, is because I don't think this should be a feature in the mod, but just thought that it would still be handy**

## License
Distributed under the GNU General Public License 3.0. See `LICENSE` for more information.

**If the original creator would like for me to take this project down, then please let me know!**

## Build
If you want to build this yourself, please clone the repository and execute `gradlew build` in the projects folder. 

Artifacts will be generated at `build/libs`
