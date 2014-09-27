
use pocketmine\item\Item;
use pocketmine\level\Level;
use pocketmine\Player;

class SignPost extends Transparent{
	public function __construct($meta = 0){
		parent::__construct(self::SIGN_POST, $meta, "Sign Post");
		$this->isSolid = false;
		$this->isFullBlock = false;
		$this->hardness = 5;
	}

	public function getBoundingBox(){
		return null;
	}


	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		if($face !== 0){
			$faces = [
				2 => 2,
				3 => 3,
				4 => 4,
				5 => 5,
			];
			if(!isset($faces[$face])){
				$this->meta = floor((($player->yaw + 180) * 16 / 360) + 0.5) & 0x0F;
				$this->getLevel()->setBlock($block, Block::get(Item::SIGN_POST, $this->meta), true);

				return true;
			}else{
				$this->meta = $faces[$face];
				$this->getLevel()->setBlock($block, Block::get(Item::WALL_SIGN, $this->meta), true);

				return true;
			}
		}

		return false;
	}

	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL){
			if($this->getSide(0)->getID() === self::AIR){ //Replace with common break method
				//TODO
				//Server::getInstance()->api->entity->drop($this, Item::get(SIGN, 0, 1));
				$this->getLevel()->setBlock($this, new Air(), true, true, true);

				return Level::BLOCK_UPDATE_NORMAL;
			}
		}

		return false;
	}

	public function onBreak(Item $item){
		$this->getLevel()->setBlock($this, new Air(), true, true, true);

		return true;
	}

	public function getDrops(Item $item){
		return [
			[Item::SIGN, 0, 1],
		];
	}
}