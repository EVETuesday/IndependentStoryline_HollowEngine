//val players by server.players.filter { it.name.string == "_K1duTsy_"}  это по нику, ниже первый в табе

val players by server.players
val player = players().first()

val npcgelmoo by NPCEntity.creating {
	name = "Гельмо"
    model = "is:models/npc/Gelmo.gltf"
    showName = false
    world = "minecraft:overworld"
    animations[AnimationType.WALK] = "walk"
    animations[AnimationType.IDLE] = "idle5"
    pos = pos(-1531.5, 291.5, -213.5)
}

val npcmindos by NPCEntity.creating{
    name = "Миндос"
    model = "is:models/npc/Mindos.gltf"
    showName = false
    world = "minecraft:overworld"
    animations[AnimationType.WALK] = "walk"
    pos = pos(-1534, 291.5, -224)
}

val npcalfia by NPCEntity.creating{
    name = "Альфия"
    model = "is:models/npc/alfia.gltf"
    textures["classic"] = ""
    showName = false
    world = "minecraft:overworld"
    pos = pos(-1532, 291.5, -223)
    animations[AnimationType.WALK] = "walk"
}

val npcgerdes by NPCEntity.creating{
    name = "Гердес"
    model = "is:models/npc/gerdec.gltf"
    showName = false
    animations[AnimationType.WALK] = "walk"
    world = "minecraft:overworld"
    pos = pos(-1531, 291.5, -223)
    animations[AnimationType.IDLE] = "idle5"
}

val npcfanzia by NPCEntity.creating{
    name = "Фанзия"
    model = "is:models/npc/fanzia.gltf"
    showName = false
    animations[AnimationType.WALK] = "walk"
    world = "minecraft:overworld"
    pos = pos(-1530, 291.5, -221)
    animations[AnimationType.IDLE] = "idle5"
}
async {
	npcalfia.isRunning = true
	npcalfia moveTo {pos (-1532, 291, -215)}
	npcalfia.isRunning = false
	npcalfia lookAlwaysAt npcgelmoo
}
async {
	npcgerdes.isRunning = true
	npcgerdes moveTo {pos (-1531, 291, -216)}
	npcgerdes.isRunning = false
	npcgerdes lookAlwaysAt npcgelmoo
}
async {
	npcfanzia.isRunning = true
	npcfanzia moveTo {pos (-1530, 291, -217)}
	npcfanzia.isRunning = false
	npcfanzia lookAlwaysAt npcgelmoo
}
async {
	npcmindos.isRunning = true
	npcmindos moveTo {pos (-1534, 291, -214)}
	npcmindos.isRunning = false
	npcmindos lookAlwaysAt npcgelmoo
	npcgelmoo lookAlwaysAt{pos (-1532, 292.3, -236)}
	wait { 4.sec }

	npcalfia say { "Гельмо, мы же просили не предпринимать самому никаких решений." }

	npcalfia playFreeze { "angry" }
	npcgerdes playFreeze{"shook"}
	npcgelmoo playFreeze{"sad"}

	wait { 4.sec }

	npcmindos say { "Да тише, Альфия! Новичок-то самого Модиума покоцал!" }
	npcgerdes stop {"shook"}
	npcalfia stop { "angry" }
	npcalfia playOnce {"vzdoh"}

	wait { 4.sec }
	npcfanzia playFreeze { "hmm" }
	npcfanzia say { "Наконец-то Модиум свергнут..." }

	wait { 4.sec }
	npcfanzia stop {"hmm"}
	npcgerdes say { "Гельмо, а ты молодец. Не думал, что ты справишься." }

	wait { 4.sec }
	npcmindos playOnce{"morgaet"}

	npcgerdes say { "Оставайся подоль нас. Надо еще разобраться, что с тобой делать." }

	npcgerdes playFreeze { "hat-HeadphoneMic" }
	
	wait { 2.sec }
	npcgelmoo stop {"sad"}

	npcgerdes stop { "hat-HeadphoneMic" }

	wait { 2.sec }

	players say { "Мне некуда идти, да и я ничего не знаю ни об этом месте, ни о себе." }

	wait { 4.sec }
	npcgelmoo playFreeze{"hmm"}

	players say { "Я думаю, мне пока что безопаснее рядом с вами. " }
	wait {5.sec}
	
	fadeIn {
	text = "Две недели"
	subtitle = "спустя..."
	color = 0x000000
	time = 3.sec
	}
}

camera {
	spline(41.sec, "end_cutscene_var25.nbt.nbt", Interpolation.QUINT_IN_OUT, false)
}
async {
	npcgelmoo.despawn()
	players.tpTo{
		pos = pos(-1547.6, 291, -184)
		vec= vec(-0, 30)
	}

	fadeOut {
		text = ""
		subtitle = ""
		color = 0x000000
		time = 2.sec
	}
}

val npcgelmo by NPCEntity.creating {
		name = "Гельмо"
	    model = "is:models/npc/Gelmo.gltf"
	    showName = false
	    world = "minecraft:overworld"
	    animations[AnimationType.WALK] = "walk"
	    animations[AnimationType.IDLE] = "idle5"
	    pos = pos(-1547.9, 291, -184.6)
	}

async {
	wait{1.sec}
	npcgelmo lookAt{pos(-1547.9, 290, -175)}
	players say { "Мы до сих пор не выяснили, как я тут оказался. Модиум говорил, что может помочь. С другой стороны, как бы он мне помог..." }
	npcgelmo playFreeze{"hmm"}
	wait { 5.sec }

	players say { "Как же всё тяжело. " }
	npcgelmo stop {"hmm"}
	npcgelmo lookAt{pos(-1547.9, 295, -180)}
	wait { 4.sec }
	npcgelmo lookAlwaysAt{pos(-1548, 290, -187)}
	players say { "Меня кто-то зовёт..." }
	wait{1.sec}
	
	fadeIn {
	text = ""
	subtitle = ""
	color = 0x000000
	time = 2.sec
	}
}

camera {
	spline(16.sec, "end_cutscene_var12.nbt.nbt", Interpolation.QUAD_IN, true)
}

wait { 5.sec }
npcgelmo.despawn()

npcgerdes.despawn()

npcfanzia.despawn()

npcmindos.despawn()

npcalfia.despawn()
fadeOut {
	text = ""
	subtitle = ""
	color = 0x000000
	time = 2.sec
}

wait{2.sec}
players send {"§5Конец первой серии."}