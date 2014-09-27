
use pocketmine\item\Item;
use pocketmine\Player;

class TNT extends Solid{
	public function __construct(){
		parent::__construct(self::TNT, 0, "TNT");
		$this->hardness = 0;
		$this->isActivable = true;
	}

	public function onActivate(Item $item, Player $player = null){
		if($item->getID() === Item::FLINT_STEEL){
			if(($player->gamemode & 0x01) === 0){
				$item->useOn($this);
			}
			$data = [
				"x" => $this->x + 0.5,
				"y" => $this->y + 0.5,
				"z" => $this->z + 0.5,
				"power" => 4,
				"fuse" => 20 * 4, //4 seconds
			];
			$this->getLevel()->setBlock($this, new Air(), false, false, true);
			//TODO
			//$e = Server::getInstance()->api->entity->add($this->level, ENTITY_OBJECT, OBJECT_PRIMEDTNT, $data);
			//$e->spawnToAll();

			return true;
		}

		return false;
	}
}