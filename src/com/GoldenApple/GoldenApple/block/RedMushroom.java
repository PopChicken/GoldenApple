
use pocketmine\item\Item;
use pocketmine\level\Level;
use pocketmine\Player;

class RedMushroom extends Flowable{
	public function __construct(){
		parent::__construct(self::RED_MUSHROOM, 0, "Red Mushroom");
		$this->hardness = 0;
	}

	public function getBoundingBox(){
		return null;
	}


	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL){
			if($this->getSide(0)->isTransparent === true){ //Replace with common break method
				//TODO
				//Server::getInstance()->api->entity->drop($this, Item::get($this->id));
				$this->getLevel()->setBlock($this, new Air(), false);

				return Level::BLOCK_UPDATE_NORMAL;
			}
		}

		return false;
	}

	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		$down = $this->getSide(0);
		if($down->isTransparent === false){
			$this->getLevel()->setBlock($block, $this, true, true);

			return true;
		}

		return false;
	}
}