
use pocketmine\item\Item;
use pocketmine\level\Level;
use pocketmine\Player;

class BrownMushroom extends Flowable{
	public function __construct(){
		parent::__construct(self::BROWN_MUSHROOM, 0, "Brown Mushroom");
		$this->hardness = 0;
	}

	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL){
			if($this->getSide(0)->isTransparent === true){ //Replace with common break method
				$this->getLevel()->dropItem($this, Item::get($this->id));
				$this->getLevel()->setBlock($this, new Air(), false, false, true);

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

	public function getBoundingBox(){
		return null;
	}

}