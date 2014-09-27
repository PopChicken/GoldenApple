

use pocketmine\math\AxisAlignedBB;

class SoulSand extends Solid{
	public function __construct(){
		parent::__construct(self::SOUL_SAND, 0, "Soul Sand");
		$this->hardness = 2.5;
	}

	public function getBoundingBox(){
		return new AxisAlignedBB(
			$this->x,
			$this->y,
			$this->z,
			$this->x + 1,
			$this->y + 1 - 0.125,
			$this->z + 1
		);
	}

}