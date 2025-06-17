val player by server.players
val fz by NPCEntity.creating{
	name = "Фанзия"
    model = "is:models/npc/fanzia.gltf"
    pos = pos(-1530, 291, -223)
    showName = false
    animations[AnimationType.IDLE] = "idle5"
}
val alf by NPCEntity.creating{
	name = "Альфия"
    model = "is:models/npc/alfia.gltf"
    pos = pos(-1531, 291, -224)
    showName = false
}
val gds by NPCEntity.creating{
	name = "Гердес"
    model = "is:models/npc/gerdec.gltf"
    pos = pos(-1532, 291, -223)
    showName = false
}
val md by NPCEntity.creating{
	name = "Миндос"
    model = "is:models/npc/Mindos.gltf"
    pos = pos(-1533, 291, -221)
    showName = false
    animations[AnimationType.IDLE] = "mindosmorgaet"
}
val modium by NPCEntity.creating {
	name = "Модиум"
    model = "is:models/npc/modium.gltf"
    pos = pos(-1531.4, 291.5, -212.2)
    showName = false
    rotation = vec(-180f, 3f)
}
val gelmo by NPCEntity.creating{
	name = "Gelmosha"
    model = "is:models/npc/Gelmo.gltf"
    pos = pos(-1531.4, 291.5, -215.7)
    showName = false
    animations[AnimationType.IDLE] = "idle5"
}

fz lookAlwaysAt gelmo
gds lookAlwaysAt gelmo
alf lookAlwaysAt gelmo
md lookAlwaysAt gelmo

async{
	gelmo lookAlwaysAt{pos(-1531.4, 291, -214.7)}
	modium lookAlwaysAt{pos(-1532, 292.3, -236)}
	modium playFreeze{"lose"}
	wait { 4.sec }

	md say { "Что ты наделал..." }

	wait { 4.sec }

	alf say { "Гельмо, зачем?" }
	gelmo.stopLookAlways()
	gelmo lookAlwaysAt gds
	alf playOnce {"vzdoh"}

	wait { 4.sec }

	gds say { "Чёрт возьми, мы остальным передали то, что Модиума возьмём живьем." }

	gds playFreeze{"shook"}

	wait { 4.sec }
	gds stop {"shook"}
	gds say { "Я думаю, можно сказать, что сопротивление было слишком сильным. " }

	fz playLooped {"hmm"}
	gds playFreeze {"angry"}
	gelmo.stopLookAlways()
	gelmo lookAlwaysAt alf
	wait { 4.sec }

	fz stop {"hmm"}
	fz playFreeze{"angry"}

	md say { "Можно. Но только без Гельмо, его с нами не было. Нельзя подставлять репутацию команды." }

	md playFreeze {"mindospodozrevaet"}

	wait { 4.sec }

	md stop {"mindospodozrevaet"}

	alf say { "Гельмо, проваливай. " }
	alf playFreeze{"sad"}

	md playFreeze {"angry"}

	wait { 4.sec }

	md stop {"angry"}

	alf say { "Дальше мы сами." }

	wait { 4.sec }

	player say { "Я сделал то, что посчитал правильным. Простите." }
	wait{4.sec}
	fadeIn{
		text = ""
		subtitle = ""
		color = 0x000000
		time = 40
	}
}

camera {
	spline(40.sec, "end_cutscene_var1.nbt.nbt", Interpolation.QUAD_IN, false)
}

player.tpTo{
	pos = pos(-1531, 200, -97)
	vec = vec(-180, -5)
}
wait{2.sec}
fadeOut{}

md.despawn()
fz.despawn()
alf.despawn()
gds.despawn()
gelmo.despawn()
modium.despawn()

playSound {
	sound = "challenge_complete"
	volume = 10f
}

player send {"§5Конец первой серии."}