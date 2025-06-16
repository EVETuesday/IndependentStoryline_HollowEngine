import net.minecraft.server.level.ServerPlayer

val player by server.players
var me = player()[0]

val npc1 by NPCEntity.creating {
    name = "Эдгар"
    model = "IS:models/npc/gerdec.gltf""
    textures["classic"] = ""
    showName = false
    pos = pos(603.8, 101.0, -1919.3)
}

val npc2 by NPCEntity.creating {
    name = "Эдгар"
    model = "IS:models/npc/gerdec.gltf""
    textures["classic"] = ""
    showName = false
    pos = pos(593.9, 101.0, -1920.3)
}

fun npcGuardZone(x: Double, y: Double, z: Double, message: String) = async {
    fun <T> IContextBuilder.notNullElse(v: T?, def: T): T {
        var ret = def
        if (v != null) {
            ret = v!!
        }
        return ret
    }

    var npcEntity1 = NPCEntity(me.level)
    var npcEntity2 = NPCEntity(me.level)
    var npcEntity3 = NPCEntity(me.level)

    next {
        npcEntity1 = notNullElse(npc1.invoke(), NPCEntity(me.level))
        npcEntity2 = notNullElse(npc2.invoke(), NPCEntity(me.level))
    }

    val executeTask = async {
        While({!npcEntity3.isRemoved() && !npcEntity1.isRemoved() && !npcEntity2.isRemoved()}) { 
            If({npcEntity1.closerThan(me, 3.0)}) {
                npc1.say({message})
                next {
                    me.teleportTo(x, y, z)
                }
            }
            If({npcEntity2.closerThan(me, 3.0)}) {
                npc2.say({message})
                next {
                    me.teleportTo(x, y, z)
                }
            }
        }
    }
}

/* npcGuardZone(600.0, 101.0, -1907.1, "Э, ты куда полез черт>:(") */