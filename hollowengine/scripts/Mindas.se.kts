val npc1 by NPCEntity.creating {
    name = "Эдгар"
    model = "is:models/npc/fanzia.gltf"
    textures["classic"] = ""
    showName = false
    pos = pos(603.8, 101.0, -1919.3)
}

val npc2 by NPCEntity.creating {
    name = "Эдгар"
    model = "is:models/npc/alfia.gltf"
    textures["classic"] = ""
    showName = false
    pos = pos(605.8, 101.0, -1919.3)
}

val npc3 by NPCEntity.creating {
    name = "Эдгар"
    model = "is:models/npc/gerdec.gltf"
    textures["classic"] = ""
    showName = false
    pos = pos(607.8, 101.0, -1919.3)
}

val npc4 by NPCEntity.creating {
    name = "Эдгар"
    model = "is:models/npc/modium.gltf"
    textures["classic"] = ""
    showName = false
    pos = pos(609.8, 101.0, -1919.3)
}

val npc5 by NPCEntity.creating {
    name = "Эдгар"
    model = "is:models/npc/Mindos.gltf"
    textures["classic"] = ""
    showName = false
    pos = pos(611.8, 101.0, -1919.3)
}

npc1.play {
	animation = "fanzya"
	layerMode = LayerMode.OVERWRITE
	playType = PlayMode.LOOPED
	speed = 0.3f
}

npc2.play {
	animation = "alfia"
	layerMode = LayerMode.OVERWRITE
	playType = PlayMode.LOOPED
	speed = 0.3f
}

npc3.play {
	animation = "Gerdes"
	layerMode = LayerMode.OVERWRITE
	playType = PlayMode.LOOPED
	speed = 0.3f
}

npc4.play {
	animation = "modium"
	layerMode = LayerMode.OVERWRITE
	playType = PlayMode.LOOPED
	speed = 0.3f
}

npc5.play {
	animation = "mindosmorgaet"
	layerMode = LayerMode.OVERWRITE
	playType = PlayMode.LOOPED
	speed = 0.3f
}

// npc1 playLooped {"fanzya"}